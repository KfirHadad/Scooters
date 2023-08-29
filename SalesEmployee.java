import java.util.Vector;

public class SalesEmployee extends Employee {

	private double commRate;
	private int salesCount;
	private double sumCommision;

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
		// TODO Auto-generated method stub
		return true;
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
		
		sumCommision += (commRate/100);
		
		return esv.elementAt(0);
	}
	
}
