public class Customer implements Comparable<Customer> {
	private int ID;
	private String fName;
	private int age;
	private char gender;
	private boolean helmet;
	private boolean lock;
	private ElectricScooter scooter;
	private double totalPayment; // Assuming you have a property to store the payment

	public Customer(int ID, String fName, int age, char gender, boolean helmet, boolean lock)
			throws invalidEmployeeInputException {
		if (isValidGender(gender)) {
			this.ID = ID;
			this.fName = fName;
			this.age = age;
			this.gender = gender;
			this.helmet = helmet;
			this.lock = lock;
			this.scooter = null;
			registrationFee();

		} else
			throw new invalidEmployeeInputException("Gender must be m/w/o.");
	}

	public Customer(int ID, String fName, int age, char gender, boolean helmet, boolean lock, ElectricScooter scooter)
			throws invalidEmployeeInputException {
		if (isValidGender(gender)) {
			this.ID = ID;
			this.fName = fName;
			this.age = age;
			this.gender = gender;
			this.helmet = helmet;
			this.lock = lock;
			this.scooter = scooter;
			if (scooter != null)
				totalPayment = totalPayment + scooter.getPrice();
		} else
			throw new invalidEmployeeInputException("Gender must be m/w/o.");
	}

	@Override
	public int compareTo(Customer other) {
		// Compare customers based on totalPayments
		return Double.compare(this.totalPayment, other.totalPayment);
	}

	private void registrationFee() {
		setPayment(30);
		System.out.println("this customer paid 30$");
	}

	private boolean isValidGender(char c) {
		return c == 'm' || c == 'f' || c == 'u';
	}

	private void setPayment(int p) {
		this.totalPayment = this.totalPayment + p;
	}

	public ElectricScooter getScooter() {
		return scooter;
	}

	public void setScooter(ElectricScooter scooter) {
		// Update totalPayments when a new scooter is purchased
		if (scooter != null) {
			totalPayment = totalPayment + scooter.getPrice();
		}
		this.scooter = scooter;
	}

	public int getID() {
		return ID;
	}

	public String getfName() {
		return fName;
	}

	public int getAge() {
		return age;
	}

	public char getGender() {
		return gender;
	}

	public boolean hasHelmet() {
		return helmet;
	}

	public boolean hasLock() {
		return lock;
	}

	public double getTotalPayments() {
		return totalPayment;
	}

}
