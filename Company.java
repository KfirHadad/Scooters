import java.io.*;
import java.util.*;

public class Company{
    private List<Customer> customers;
    private List<Employee> employees;
    private List<ElectricScooter> scootersForSale;
    private List<ServiceCall> serviceCalls;

    public Company(String customerFilePath, String employeeFilePath, String scooterFilePath, String serviceCallFilePath) {
        this.customers = new ArrayList<>();
        this.employees = new ArrayList<>();
        this.scootersForSale = new ArrayList<>();
        this.serviceCalls = new ArrayList<>();

        // Read data from text files and create objects
        readCustomers(customerFilePath);
        readEmployees(employeeFilePath);
        readScooters(scooterFilePath);
        readServiceCalls(serviceCallFilePath);

        // Update employee profits based on service calls
        updateEmployeeProfits();
    }

    public void addCustomer(Customer c) {
        customers.add(c);
    }

    public void addEmployee(Employee e) {
        employees.add(e);
    }

    public void addElectricScooter(ElectricScooter es) {
        scootersForSale.add(es);
    }

    public boolean serviceForCustomer(int customerID, String serviceType, ElectricScooter quickES) {
        // Find the customer by ID
        Customer customer = findCustomerByID(customerID);

        if (customer == null) {
            return false; // Customer not found
        }

        // Find the employee with the lowest total accumulated commissions
        Employee chosenEmployee = findEmployeeWithLowestCommissions(serviceType);

        if (chosenEmployee == null) {
            return false; // No suitable employee found
        }

        // Create and execute a service call
        ServiceCall serviceCall = new ServiceCall(customer, chosenEmployee, serviceType, quickES);
        serviceCalls.add(serviceCall);

        return true; // Service call created and executed
    }

    public double purchasedQuickScooterRatio() {
        int totalServiceCalls = serviceCalls.size();
        int quickScooterServiceCalls = 0;

        for (ServiceCall serviceCall : serviceCalls) {
            if (serviceCall.isQuickScooterService()) {
                quickScooterServiceCalls++;
            }
        }

        if (totalServiceCalls == 0) {
            return 0.0; // To avoid division by zero
        }

        return (double) quickScooterServiceCalls / totalServiceCalls * 100.0;
    }

    public double totalRevenues(List<? extends Profitable> objects) {
        double totalProfits = 0.0;

        for (Profitable object : objects) {
            totalProfits += object.getProfit();
        }

        return totalProfits;
    }

    public <T extends Comparable<T>> T getMin(List<T> objects) {
        if (objects.isEmpty()) {
            return null;
        }

        T minObject = objects.get(0);

        for (T object : objects) {
            if (object.compareTo(minObject) < 0) {
                minObject = object;
            }
        }

        return minObject;
    }

    public int updatedRates(List<? extends Updateable> objects) {
        int updatedCount = 0;

        for (Updateable object : objects) {
            if (object.update()) {
                updatedCount++;
            }
        }

        return updatedCount;
    }

    private void readCustomers(String filePath) {
        // Implement reading customers from a file and adding them to the 'customers' list
        // Example: Read data line by line, create Customer objects, and add them to the list
        try (Scanner scanner = new Scanner(new File(filePath))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // Parse customer data and create Customer objects
                // Add created customers to the 'customers' list
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void readEmployees(String filePath) {
        // Implement reading employees from a file and adding them to the 'employees' list
        // Example: Read data line by line, create Employee objects, and add them to the list
        try (Scanner scanner = new Scanner(new File(filePath))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // Parse employee data and create Employee objects
                // Add created employees to the 'employees' list
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void readScooters(String filePath) {
        // Implement reading scooters from a file and adding them to the 'scootersForSale' list
        // Example: Read data line by line, create ElectricScooter objects, and add them to the list
        try (Scanner scanner = new Scanner(new File(filePath))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // Parse scooter data and create ElectricScooter objects
                // Add created scooters to the 'scootersForSale' list
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void readServiceCalls(String filePath) {
        // Implement reading service calls from a file and adding them to the 'serviceCalls' list
        // Example: Read data line by line, create ServiceCall objects, and add them to the list
        try (Scanner scanner = new Scanner(new File(filePath))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // Parse service call data and create ServiceCall objects
                // Add created service calls to the 'serviceCalls' list
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void updateEmployeeProfits() {
        for (ServiceCall serviceCall : serviceCalls) {
            Employee employee = serviceCall.getEmployee();
            if (employee != null) {
                double profit = serviceCall.getProfit();
                employee.updateProfit(profit);;
            }
        }
    }

    private Customer findCustomerByID(int customerID) {
        for (Customer customer : customers) {
            if (customer.getID() == customerID) {
                return customer;
            }
        }
        return null; // Customer not found
    }
    
    private Employee findEmployeeWithLowestCommissions(String serviceType) {
        Employee lowestCommissionEmployee = null;
        double lowestCommissions = Double.MAX_VALUE;

        for (Employee employee : employees) {
            if (employee.canHandleService(serviceType)) {
                double commissions = employee.getAccumulatedCommissions();
                if (commissions < lowestCommissions) {
                    lowestCommissions = commissions;
                    lowestCommissionEmployee = employee;
                }
            }
        }

        return lowestCommissionEmployee;
    }
}