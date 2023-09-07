public class Customer implements Comparable<Customer> {
	private int totalPayments;
	private int ID;
	private String fName;
	private int age;
	private char gender;
	private boolean helmet;
	private boolean lock;
	private ElectricScooter scooter;
	private int payment; // Assuming you have a property to store the payment

	public Customer(int ID, String fName, int age, char gender, boolean helmet, boolean lock, SalesEmployee salesEmployee) {
		if (isValidGender(gender)) {
			registrationFee();
			this.ID = ID;
			this.fName = fName;
			this.age = age;
			this.gender = gender;
			this.helmet = helmet;
			this.lock = lock;

			// Call sellCheapestScooter() on the provided SalesEmployee instance
			ElectricScooter availableScooter = salesEmployee.sellCheapestScooter();

			if (availableScooter != null) {
				// If the customer already has a scooter, replace it with the new one
				if (this.scooter != null) {
					// Return the replaced scooter to the company's registry
					SalesEmployee.returnScooter(this.scooter);
				}
				this.scooter = availableScooter;
			} else {
				System.out.println("No scooters available for the customer.");
			}
		} else {
			System.out.println("Invalid gender. Gender must be m/w/u.");
		}
	}
	public Customer (int ID, String fname, int age, char gender, boolean helmet, boolean lock, ElectricScooter scooter) 
	{

	}

	private void registrationFee() {
		setPayment(30);
		System.out.println("This customer paid 30$");
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

	// Method for a customer to bring their own scooter for service
	public void bringScooterForService(ElectricScooter scooter) {
		// Check if the customer already has a scooter and return it to the company's registry
		if (this.scooter != null) {
			SalesEmployee.returnScooter(this.scooter);
		}
		// Set the customer's scooter to the one they brought for service
		this.scooter = scooter;
	}
}
