import java.util.List;
import java.util.Scanner;

public class ConsoleDemo {
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        System.out.println("============================================");
        System.out.println("Restaurant Management System - Console Demo");
        System.out.println("(JDBC Operations - Demo for Experiment 10)");
        System.out.println("============================================\n");
        
        // Demonstrate Restaurant CRUD
        demonstrateRestaurantOperations();
        
        // Demonstrate MenuItem CRUD
        demonstrateMenuItemOperations();
        
        System.out.println("\n============================================");
        System.out.println("Demo Complete!");
        System.out.println("For full JavaFX GUI, compile with JavaFX SDK");
        System.out.println("============================================");
    }
    
    private static void demonstrateRestaurantOperations() {
        System.out.println("--- Restaurant Operations ---\n");
        
        System.out.println("1. Adding Sample Restaurants:");
        DatabaseManager.insertRestaurant("Cafe Java", "123 Main St", "Coffee");
        DatabaseManager.insertRestaurant("Pizza Palace", "456 Oak Ave", "Italian");
        DatabaseManager.insertRestaurant("Burger Barn", "789 Park Rd", "American");
        System.out.println("   ✓ 3 restaurants added\n");
        
        System.out.println("2. Retrieving All Restaurants:");
        List<Restaurant> restaurants = DatabaseManager.getAllRestaurants();
        System.out.println("   " + String.format("%-5s %-20s %-25s %-15s", "ID", "Name", "Location", "Cuisine"));
        System.out.println("   " + "─".repeat(70));
        for (Restaurant r : restaurants) {
            System.out.println("   " + String.format("%-5d %-20s %-25s %-15s", 
                r.getId(), r.getName(), r.getLocation(), r.getCuisine()));
        }
        System.out.println();
        
        System.out.println("3. Updating a Restaurant:");
        if (!restaurants.isEmpty()) {
            Restaurant first = restaurants.get(0);
            DatabaseManager.updateRestaurant(first.getId(), "Cafe Java Updated", "124 Main St", "Coffee");
            System.out.println("   ✓ Updated: " + first.getName() + " -> Cafe Java Updated\n");
        }
    }
    
    private static void demonstrateMenuItemOperations() {
        System.out.println("--- Menu Item Operations ---\n");
        
        System.out.println("1. Adding Sample Menu Items:");
        DatabaseManager.insertMenuItem("Espresso", 45, 1);
        DatabaseManager.insertMenuItem("Cappuccino", 65, 1);
        DatabaseManager.insertMenuItem("Margherita Pizza", 250, 2);
        DatabaseManager.insertMenuItem("Cheese Burger", 85, 3);
        System.out.println("   ✓ 4 menu items added\n");
        
        System.out.println("2. Retrieving All Menu Items:");
        List<MenuItem> items = DatabaseManager.getAllMenuItems();
        System.out.println("   " + String.format("%-5s %-20s %-8s %-20s", "ID", "Item Name", "Price", "Restaurant"));
        System.out.println("   " + "─".repeat(60));
        for (MenuItem item : items) {
            System.out.println("   " + String.format("%-5d %-20s %-8d %-20s", 
                item.getId(), item.getName(), item.getPrice(), item.getRestaurantName()));
        }
        System.out.println();
        
        System.out.println("3. Updating a Menu Item:");
        if (!items.isEmpty()) {
            MenuItem first = items.get(0);
            DatabaseManager.updateMenuItem(first.getId(), first.getName(), 50);
            System.out.println("   ✓ Updated: " + first.getName() + " price to 50\n");
        }
        
        System.out.println("4. Deleting a Menu Item:");
        if (items.size() > 1) {
            MenuItem toDelete = items.get(items.size() - 1);
            DatabaseManager.deleteMenuItem(toDelete.getId());
            System.out.println("   ✓ Deleted: " + toDelete.getName() + "\n");
        }
        
        System.out.println("5. Final Menu Items List:");
        items = DatabaseManager.getAllMenuItems();
        System.out.println("   " + String.format("%-5s %-20s %-8s %-20s", "ID", "Item Name", "Price", "Restaurant"));
        System.out.println("   " + "─".repeat(60));
        for (MenuItem item : items) {
            System.out.println("   " + String.format("%-5d %-20s %-8d %-20s", 
                item.getId(), item.getName(), item.getPrice(), item.getRestaurantName()));
        }
    }
}
