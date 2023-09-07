import java.util.*;

public class TechnicalEmployee extends Employee {

	private double commision;
	private Vector<Integer> servicePaymentVector = new Vector<Integer>();
	private Vector<Double> serviceCommisionVector = new Vector<Double>();
	private double revenue;
	private boolean fg = true;

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

		if (fg) {
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
		} else
			System.out.println("this employee already used got his first grant");
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
	
	@Override
    public boolean canHandleService(String serviceType) {
        return "technical".equals(serviceType);
    }

    @Override
    public double getAccumulatedCommissions() {
    	return this.commision;
    }

	public void technicalService(ElectricScooter es) {
		int scooterMaxSpeed = es.getMaxSpeed();
		String scooterModel = es.getModel();
		chargeCustomer();
		serviceCommisionVector.add(0, commision);
		setTotalSumCommision(getTotalSumCommision() + this.commision);
		setTempSumCommision(getTempSumCommision() + this.commision);

		setRevenue();

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
			servicePaymentVector.add(0, 10);
		else if (pr < 0.5)
			servicePaymentVector.add(0, 30);
		else if (pr < 0.9)
			servicePaymentVector.add(0, 80);
		else if (pr >= 0.9)
			servicePaymentVector.add(0, 120);
	}
	
	public double getCommision() {
		return this.commision;
	}

	private void setRevenue() {
		revenue = servicePaymentVector.elementAt(0) - serviceCommisionVector.elementAt(0);
		ServiceCall.insertRevenues(this.revenue);
	}

}
