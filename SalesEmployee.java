import java.util.Vector;

public class SalesEmployee extends Employee {

	private double commRate;
	private int salesCount;
	
	private Vector<Integer> salesPaymentVector = new Vector<Integer>();
	private Vector<Double> salesCommisionVector = new Vector<Double>();

	public SalesEmployee(int ID, String fName, int age, char gender, char shirtSize, double commRate)
			throws invalidEmployeeInputException {
		super(ID, fName, age, gender, shirtSize);
		this.commRate = commRate;
		salesCount = 0;

	}

	@Override
	public void firstGrant() {

		int a = super.getShirtSize();
		switch (a) {
		case 's':
			setFirstGrant(10);
		case 'm':
			setFirstGrant(15);
		case 'l':
			setFirstGrant(20);
		case 'x':
			setFirstGrant(15);
		}
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
		salesCommisionVector.add(this.commRate);
		salesCount = salesCount + 1;
		chargeCustomer(esv.elementAt(0).getPrice());

		return esv.elementAt(0);
	}

	private void chargeCustomer(int price) {
		salesPaymentVector.add(price);
	}

}
