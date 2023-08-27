class QuickElectricScooter extends ElectricScooter {

	private double appVersion;

	private static int quickScooterSales = 0;

	public QuickElectricScooter(int serialNumber, int price, String model, int maxSpeed, double appVersion)
			throws notValidPriceException {
		super(serialNumber, price, model, maxSpeed);
		this.appVersion = appVersion;

		quickScooterSales++;
	}

	public static int getSales() {
		return quickScooterSales;
	}

	public boolean update() {
		if (getSales() > ElectricScooter.getSales()) {
			super.setPrice((int) (getPrice() * 1.1));
			return true;
		} else
			return false;
	}

}
