import java.util.*;

public class TechnicalEmployee extends Employee {

//	private int numOfCalls;
	private int commision;
	private double totalSumCommision;
	private double tempSumCommision;
	private double lastUpdate;
	protected Vector<Integer> paymentVector = new Vector<Integer>();
	protected Vector<Integer> commisionVector = new Vector<Integer>();


	public TechnicalEmployee(int ID, String fName, int age, char gender, char shirtSize)
			throws invalidEmployeeInputException {
		super(ID, fName, age, gender, shirtSize);
//		numOfCalls = 0;
		commision = 5;
		totalSumCommision = 0.0;
		tempSumCommision = 0.0;
		lastUpdate = 0.0;
	}

	@Override
	public void firstGrant() {

		int a = super.getShirtSize();
		switch (a) {
		case 's':
			setFirstGrant(30);
		case 'm':
			setFirstGrant(35);
		case 'l':
			setFirstGrant(35);
		case 'x':
			setFirstGrant(40);
		}
	}

	public void technicalService(ElectricScooter es) {
		int scooterMaxSpeed = es.getMaxSpeed();
		String scooterModel = es.getModel();
		chargeCustomer();
		commisionVector.add(commision);
		totalSumCommision += commision;
		tempSumCommision += commision;
		if (es instanceof QuickElectricScooter) {

			System.out.println("Thank you for coming to us");
			System.out.println(scooterMaxSpeed + " " + scooterModel);
			System.out.println("Hope to see you again");
		} else {
			System.out.println(scooterMaxSpeed + " " + scooterModel);
		}
	}

	private void chargeCustomer() {
		double pr = Math.random();
		if (pr < 0.3)
			paymentVector.add(10);
		else if (pr < 0.5)
			paymentVector.add(30);
		else if (pr < 0.9)
			paymentVector.add(80);
		else if (pr >= 0.9)
			paymentVector.add(120);
	}

	public int getCommision() {
		return this.commision;
	}

	@Override
	public boolean update() {
		if (lastUpdate * 1.5 < tempSumCommision) {
			commision += 2;
			lastUpdate = tempSumCommision;
			tempSumCommision = 0;
			return true;
		}
		return false;

	}

}
