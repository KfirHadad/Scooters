import java.util.*;

public class ServiceCall implements Comparable<ServiceCall> {

	private Customer customer;
	private Employee employee;
	private String serviceType;
	private ElectricScooter electricScooter;
	private double revenue;

	private static Vector<Double> revenuesVector = new Vector<Double>();

	public ServiceCall(Customer c, Employee e, String serviceType, ElectricScooter es) {
		if (e instanceof SalesEmployee && serviceType == "technical") {
			System.out.println("this emplyee can't help you with that");
			return;
		}
		if (e instanceof TechnicalEmployee && serviceType == "sales") {
			System.out.println("this emplyee can't help you with that");
			return;
		}
		this.customer = c;
		this.employee = e;
		this.serviceType = serviceType;
		this.electricScooter = es;
		this.revenue = getRevenue();

	}

	public static void insertRevenues(double revenue) {
		revenuesVector.add(0, revenue);
	}

	private double getRevenue() {
		return revenuesVector.elementAt(0);
	}

	@Override
	public int compareTo(ServiceCall other) {
		if (this.revenue > other.revenue) {
			return 1;
		} else if (revenue < other.revenue) {
			return -1;
		} else {
			return 0;
		}
	}
	
}