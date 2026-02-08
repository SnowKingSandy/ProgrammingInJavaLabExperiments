import java.time.Year;

public class MainForVehicle {
    public static void main(String[] args) {
        // 1. Default (Petrol)
        Vehicle v1 = new Vehicle();
        v1.brandName = "Honda";
        v1.modelName = "Civic";
        v1.fuelType = 'P'; 

        // 2. Parameterized 
        Vehicle v2 = new Vehicle("VIN-999", "Tesla", "Model 3", "White", 5, 75, 'E', Year.of(2023), 1800, 45000);

        // 3. Copy 
        Vehicle v3 = new Vehicle(v2);
        v3.setVinNumber("VIN-COPY-888");
        v3.brandName = "Toyota";
        v3.modelName = "Prius";
        v3.fuelType = 'H'; 

        System.out.println("Vehicles Created Successfully.");
        v1.displayDetails();
        v2.displayDetails();
        v3.displayDetails();
    }
}
