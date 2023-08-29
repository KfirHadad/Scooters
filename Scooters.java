public class Scooters {

    public static void main(String[] args) throws notValidPriceException, invalidEmployeeInputException{
        ElectricScooter scooter1 = new ElectricScooter(1, 500, "Model A", 25);
        ElectricScooter scooter2 = new ElectricScooter(2, 600, "Model B", 30);
        QuickElectricScooter quickScooter1 = new QuickElectricScooter(3, 700, "Model Q", 40, 2.0);
        QuickElectricScooter quickScooter2 = new QuickElectricScooter(4, 800, "Model R", 45, 3.0);

        System.out.println("Electric Scooters sold: " + ElectricScooter.getSales()); // Output: 2
        
        System.out.println(scooter1.getPrice());
        System.out.println(scooter1.update());
        System.out.println(scooter1.getPrice());
    }
}





