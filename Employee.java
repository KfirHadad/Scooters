
public abstract class Employee implements Comparable<Employee> {

	private int ID;
	private String fName;
	private int age;
	private char gender;
	private char shirtSize;
	private int firstGrant;
	
	protected int sumCommission = 0;

	public Employee(int ID, String fName, int age, char gender, char shirtSize) throws invalidEmployeeInputException {
		if (isValidGender(gender) && isValidSize(shirtSize)) {
			this.ID = ID;
			this.fName = fName;
			this.age = age;
			this.gender = gender;
			this.shirtSize = shirtSize;
		} else
			throw new invalidEmployeeInputException("Gender must be m/w/o. shirtSize must be s/m/l/x");
	}

	public abstract void firstGrant();

//	public abstract int numOfCalls();

	public abstract boolean update();

	private boolean isValidGender(char c) {
		return c == 'm' || c == 'f' || c == 'u';
	}

	private boolean isValidSize(char c) {
		return c == 's' || c == 'm' || c == 'l' || c == 'x';
	}
	
	public int compareTo(Employee other) {
		if (sumCommission > other.sumCommission) {
			return 1;
		} else if (sumCommission < other.sumCommission) {
			return -1;
		} else {
			return 0;
		}
	} 
	
	public char getShirtSize() {
		return this.shirtSize;
	}
	
	public int getFirstGrant() {
		return this.firstGrant;
	}
	
	public void setFirstGrant(int f) {
		this.firstGrant = f;
	}
	

}
