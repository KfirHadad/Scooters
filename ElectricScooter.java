import java.util.*;

class ElectricScooter implements Comparable<ElectricScooter> {
	private int serialNumber;
	private int price;
	private String model;
	private int maxSpeed;
	protected Vector<ElectricScooter> esVector = new Vector<>();

	private static int totalSales = 0;

	public ElectricScooter(int serialNumber, int price, String model, int maxSpeed) throws notValidPriceException {
		if (price <= 0) {
			throw new notValidPriceException("Price needs to be a positive integer");
		} else {
			this.price = price;
			this.serialNumber = serialNumber;
			this.model = model;
			this.maxSpeed = maxSpeed;

			if (!(this instanceof QuickElectricScooter))
				esVector.add(this);

			totalSales++;
		}
	}

	public static void sortScootersByPrice(List<ElectricScooter> scooters) {
		for (int i = 0; i < scooters.size() - 1; i++) {
			for (int j = 0; j < scooters.size() - i - 1; j++) {
				ElectricScooter scooter1 = scooters.get(j);
				ElectricScooter scooter2 = scooters.get(j + 1);

				// Compare scooters by price and swap if necessary
				if (scooter1.getPrice() > scooter2.getPrice()) {
					scooters.set(j, scooter2);
					scooters.set(j + 1, scooter1);
				}
			}
		}
	}

	@Override
	public int compareTo(ElectricScooter other) {
		if (price > other.price) {
			return 1;
		} else if (price < other.price) {
			return -1;
		} else {
			return 0;
		}
	}

	public static int getSales() {
		return totalSales - QuickElectricScooter.getSales();
	}

	public boolean update() {
		if (getSales() > QuickElectricScooter.getSales()) {
			setPrice((int) (getPrice() * 1.1));
			return true;
		} else
			return false;
	}

	public void setPrice(int p) {
		price = p;
	}

	public int getPrice() {
		return price;
	}

	public int getMaxSpeed() {
		return maxSpeed;
	}

	public String getModel() {
		return this.model;
	}
}