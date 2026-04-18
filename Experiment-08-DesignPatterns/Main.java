import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        System.out.println("========== Inventory Management System ==========");
        System.out.println("Design Patterns: Singleton, Adapter, Iterator\n");
        
        // Get singleton instance of InventoryManager
        InventoryManager manager = InventoryManager.getInstance();
        
        System.out.println("--- Adding Products to Inventory ---\n");
        
        // Add NewProduct instances
        manager.addProduct(new NewProduct("Laptop"));
        manager.addProduct(new NewProduct("Mouse"));
        manager.addProduct(new NewProduct("Keyboard"));
        
        // Add LegacyItem instances using ProductAdapter
        manager.addProduct(new ProductAdapter(new LegacyItem("LEG001", "Original Monitor")));
        manager.addProduct(new ProductAdapter(new LegacyItem("LEG002", "USB Hub")));
        manager.addProduct(new ProductAdapter(new LegacyItem("LEG003", "Network Cable")));
        
        System.out.println("\nTotal products in inventory: " + manager.getInventorySize());
        
        // Iterate through inventory using Iterator
        System.out.println("\n--- Inventory Details ---\n");
        Iterator<Product> iterator = manager.returnInventory();
        int count = 1;
        
        while (iterator.hasNext()) {
            System.out.print(count + ". ");
            Product product = iterator.next();
            product.displayDetails();
            count++;
        }
        
        System.out.println("\n========== End of Inventory ==========");
    }
}
