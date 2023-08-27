class ElectricScooter implements Comparable<ElectricScooter> {
	private int serialNumber;
	private int price;
	private String model;
	private int maxSpeed;

	private static int totalSales = 0;

	public ElectricScooter(int serialNumber, int price, String model, int maxSpeed) throws notValidPriceException {
		if (price <= 0) {
			throw new notValidPriceException("Price needs to be a positive integer");
		} else {
			this.price = price;
			this.serialNumber = serialNumber;
			this.model = model;
			this.maxSpeed = maxSpeed;

			totalSales++;
		}
	}

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
			setPrice((int) (getPrice()*1.1));
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
}