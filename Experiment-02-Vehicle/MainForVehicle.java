import java.time.Year;

public class MainForVehicle {
    public static void main(String[] args) {
        // 1. Default (Petrol)
        Vehicle v1 = new Vehicle();
        v1.brandName = "Honda";
        v1.modelName = "Civic";
        v1.color = "Silver";
        v1.fuelType = 'P';
        v1.price = 22000;
        v1.setVinNumber("VIN-001");

        // 2. Parameterized 
        Vehicle v2 = new Vehicle("VIN-002", "Tesla", "Model 3", "White", 5, 75, 'E', Year.of(2023), 1800, 45000);

        // 3. Copy 
        Vehicle v3 = new Vehicle(v2);
        v3.setVinNumber("VIN-003");
        v3.brandName = "Toyota";
        v3.modelName = "Prius";
        v3.color = "Blue";
        v3.fuelType = 'H';
        v3.price = 28000;

        // 4. Additional vehicle
        Vehicle v4 = new Vehicle("VIN-004", "BMW", "3 Series", "Black", 5, 55, 'P', Year.of(2022), 1600, 50000);

        System.out.println("=== Vehicles Created Successfully ===\n");
        v1.displayDetails();
        v2.displayDetails();
        v3.displayDetails();
        v4.displayDetails();

        System.out.println("\n=== Testing behavior on v1 ===");
        v1.start();
        v1.accelerate(30);
        v1.calcMileage(100, 5);
        v1.stop();

        // Fleet Array and Tabular Summary
        System.out.println("\n=== VEHICLE FLEET SUMMARY ===\n");
        Vehicle[] fleet = {v1, v2, v3, v4};
        
        // Print Table Header
        System.out.println("+-------+-------+-------+-------+-------+-------+-------+-------+");
        System.out.printf("| %-15s | %-15s | %-10s | %8s | %6s | %c | %4s | %12s |%n", 
            "Brand", "Model", "Color", "Price", "Fuel Cap", ' ', "Seats", "VIN");
        System.out.println("+-------+-------+-------+-------+-------+-------+-------+-------+");
        
        // Print each vehicle's details
        for (Vehicle v : fleet) {
            v.printTableRow();
        }
        
        System.out.println("+-------+-------+-------+-------+-------+-------+-------+-------+");
        System.out.println("\nTotal Vehicles in Fleet: " + fleet.length);
    }
}
