import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Restaurant Management System using JDBC\n");
        
        boolean keepRunning = true;
        Scanner scanner = new Scanner(System.in);
        
        while (keepRunning) {
            System.out.println("\n=== JDBC Operations Menu ===");
            System.out.println("1. Insert 10 Restaurants");
            System.out.println("2. Insert 10 Menu Items");
            System.out.println("3. Display All Restaurants");
            System.out.println("4. Display All Menu Items");
            System.out.println("5. Select Menu Items with Price <= 100");
            System.out.println("6. Select Menu Items from Cafe Java");
            System.out.println("7. Update Menu Items (Price <= 100 to 200)");
            System.out.println("8. Delete Menu Items starting with P");
            System.out.println("9. Exit");
            System.out.print("Enter your choice (1-9): ");
            
            int choice = scanner.nextInt();
            scanner.nextLine();
            
            switch (choice) {
                case 1:
                    System.out.println("\n--- Inserting Restaurants ---");
                    RestaurantCRUD.insertRestaurants();
                    break;
                    
                case 2:
                    System.out.println("\n--- Inserting Menu Items ---");
                    MenuItemCRUD.insertMenuItems();
                    break;
                    
                case 3:
                    RestaurantCRUD.displayAllRestaurants();
                    break;
                    
                case 4:
                    MenuItemCRUD.displayAllMenuItems();
                    break;
                    
                case 5:
                    MenuItemCRUD.selectPriceLessThan100();
                    break;
                    
                case 6:
                    MenuItemCRUD.selectFromCafeJava();
                    break;
                    
                case 7:
                    MenuItemCRUD.updatePriceLessThan100();
                    MenuItemCRUD.displayAllMenuItems();
                    break;
                    
                case 8:
                    MenuItemCRUD.deleteNameStartsWithP();
                    MenuItemCRUD.displayAllMenuItems();
                    break;
                    
                case 9:
                    keepRunning = false;
                    System.out.println("\nExiting Restaurant Management System.");
                    break;
                    
                default:
                    System.out.println("Invalid choice. Please select 1-9.");
            }
        }
        
        scanner.close();
        DatabaseConnection.closeConnection();
        System.out.println("Program terminated successfully.");
    }
}
