import java.util.Vector;

public class SalesEmployee extends Employee {

	private double commRate;
	private int salesCount;
	private boolean fg = true;

	private Vector<Integer> salesPaymentVector = new Vector<Integer>();
	private Vector<Double> salesCommisionVector = new Vector<Double>();
	public Vector<SalesEmployee> sev = new Vector<SalesEmployee>();
	private double revenue;

	public SalesEmployee(int ID, String fName, int age, char gender, char shirtSize, double commRate)
			throws invalidEmployeeInputException {
		super(ID, fName, age, gender, shirtSize);
		this.commRate = commRate;
		salesCount = 0;
		revenue = 0.0;
		sev.add(this);
	}

	@Override
	public void firstGrant() {
		if (fg) {
			fg = false;
			int a = super.getShirtSize();
			switch (a) {
			case 's':
				setFirstGrant(10);
				break;
			case 'm':
				setFirstGrant(15);
				break;
			case 'l':
				setFirstGrant(20);
				break;
			case 'x':
				setFirstGrant(15);
				break;
			}
		} else
			System.out.println("this employee already used got his first grant");
	}

	@Override
	public boolean update() {
		if (getLastUpdate() * 2 < getTempSumCommision()) {
			if (this.commRate < 30) {
				this.commRate = this.commRate * 1.02;
				return true;
			} else
				return false;
		}
		return false;
	}

	@Override
	public boolean canHandleService(String serviceType) {
		return "sales".equals(serviceType);
	}

	@Override
	public double getAccumulatedCommissions() {
		return this.commRate; 
	}

	public ElectricScooter sellScooter(Vector<ElectricScooter> esv) {
		if (esv.isEmpty())
			return null;

		for (int i = 0; i < esv.size() - 1; i++) {
			for (int j = 0; j < esv.size() - i - 1; j++) {
				ElectricScooter scooter1 = esv.get(j);
				ElectricScooter scooter2 = esv.get(j + 1);

				// Compare scooters by price and swap if necessary
				if (scooter1.getPrice() > scooter2.getPrice()) {
					esv.set(j, scooter2);
					esv.set(j + 1, scooter1);
				}
			}
		}

		setTotalSumCommision(getTotalSumCommision() + ((this.commRate) / 100) * esv.elementAt(0).getPrice());
		salesCommisionVector.add(0, this.commRate);
		salesCount = salesCount + 1;
		chargeCustomer(esv.elementAt(0).getPrice());

		setRevenue();

		return esv.elementAt(0);
	}

	private void setRevenue() {
		revenue = salesPaymentVector.elementAt(0) - salesCommisionVector.elementAt(0);
		ServiceCall.insertRevenues(this.revenue);
	}

	private void chargeCustomer(int price) {
		salesPaymentVector.add(0, price);
	}

	public SalesEmployee getSalesEmployee() {
		return this.sev.elementAt(0);
	}

}
