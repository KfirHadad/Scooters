
public abstract class Employee implements Comparable<Employee> {

	private int ID;
	private String fName;
	private int age;
	private char gender;
	private char shirtSize;
	private int firstGrant;

	private double totalSumCommision;
	private double tempSumCommision;
	private double lastUpdate;

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
		if (getTotalSumCommision() > other.getTotalSumCommision()) {
			return 1;
		} else if (getTotalSumCommision() < other.getTotalSumCommision()) {
			return -1;
		} else {
			return 0;
		}
	}

	public double getTotalSumCommision() {
		return this.totalSumCommision;
	}

	public void setTotalSumCommision(double d) {
		this.totalSumCommision = d;
	}

	public double getTempSumCommision() {
		return this.tempSumCommision;
	}

	public void setTempSumCommision(double d) {
		this.tempSumCommision = d;
	}

	public double getLastUpdate() {
		return this.lastUpdate;
	}

	public void setLastUpdate(double d) {
		this.lastUpdate = d;
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
