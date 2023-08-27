
public abstract class Employee {

	private int ID;
	private String fName;
	private int age;
	private char gender;
	private char shirtSize;

	public Employee(int ID, String fName, int age, char gender, char shirtSize) {
		this.ID = ID;
		this.fName = fName;
		this.age = age;
		this.gender = gender;
		this.shirtSize = shirtSize;
	}
	
	public abstract int firstGrant();
	
}
