public class Customer{
	private int ID;
	private String fName;
	private int age;
	private char gender;
	private boolean helmet;
	private boolean lock;
	private ElectricScooter scooter;
	private int payment; // Assuming you have a property to store the payment

	// הבנאי מיועד רק למי שאין לו קורקינט
	public Customer(int ID, String fName, int age, char gender, boolean helmet, boolean lock)
			throws invalidEmployeeInputException {
		if (isValidGender(gender)) {
			registrationFee();
			this.ID = ID;
			this.fName = fName;
			this.age = age;
			this.gender = gender;
			this.helmet = helmet;
			this.lock = lock;

			
		} else
			throw new invalidEmployeeInputException("Gender must be m/w/o.");
	}

	private void registrationFee() {
		setPayment(30);
		System.out.println("this customer paid 30$");
	}

	private boolean isValidGender(char c) {
		return c == 'm' || c == 'f' || c == 'u';
	}
	
	private void setPayment(int p) {
		this.payment = this.payment + p;
	}

	public int getPayment() {
		return payment;
	}

	public Customer(int payment) {
		this.payment = payment;
	}

}