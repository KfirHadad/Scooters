import java.util.*;

public class TechnicalEmployee extends Employee {

	private int commision;
	private Vector<Integer> servicePaymentVector = new Vector<Integer>();
	private Vector<Integer> serviceCommisionVector = new Vector<Integer>();

	public TechnicalEmployee(int ID, String fName, int age, char gender, char shirtSize)
			throws invalidEmployeeInputException {
		super(ID, fName, age, gender, shirtSize);
		commision = 5;
		setTotalSumCommision(0.0);
		setTempSumCommision(0.0);
		setLastUpdate(0.0);
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
		serviceCommisionVector.add(commision);
		setTotalSumCommision(getTotalSumCommision() + this.commision);
		setTempSumCommision(getTempSumCommision() + this.commision);
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
			servicePaymentVector.add(10);
		else if (pr < 0.5)
			servicePaymentVector.add(30);
		else if (pr < 0.9)
			servicePaymentVector.add(80);
		else if (pr >= 0.9)
			servicePaymentVector.add(120);
	}

	public int getCommision() {
		return this.commision;
	}

	@Override
	public boolean update() {
		if (getLastUpdate() * 1.5 < getTempSumCommision()) {
			commision = commision + 2;
			setLastUpdate(getTempSumCommision());
			setTempSumCommision(0.0);
			return true;
		}
		return false;

	}

}
