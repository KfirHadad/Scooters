import java.util.*;

public class ServiceCall implements Comparable<ServiceCall>, Profitable {

	private Customer customer;
	private Employee employee;
	private String serviceType;
	private ElectricScooter electricScooter;
	private double revenue;
	private boolean isQuickScooterService;

	private static Vector<Double> revenuesVector = new Vector<Double>();

	public ServiceCall(Customer c, Employee e, String serviceType, ElectricScooter es) {
		if (e instanceof SalesEmployee && serviceType.equals("technical")) {
			throw new IllegalArgumentException("Sales employees can't handle technical service.");
		}
		if (e instanceof TechnicalEmployee && serviceType.equals("sales")) {
			throw new IllegalArgumentException("Technical employees can't handle sales service.");
		}
		this.customer = c;
		this.employee = e;
		this.serviceType = serviceType;
		this.electricScooter = es;
		if(es instanceof QuickElectricScooter)
			isQuickScooterService = true;
		this.revenue = getRevenue();

	}

	public boolean isQuickScooterService() {
		return isQuickScooterService;
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

	public Employee getEmployee() {
		return this.employee;
	}

	public double getProfit() {
		return this.revenue;
	}

}