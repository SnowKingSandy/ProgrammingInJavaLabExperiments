public class TestMixed {
    public static void main(String[] args) {
        System.out.println("Testing Mixed Product Types:\n");
        
        InventoryManager manager = InventoryManager.getInstance();
        
        manager.addProduct(new NewProduct("Smartphone"));
        manager.addProduct(new ProductAdapter(new LegacyItem("OLD-001", "Old Laptop")));
        manager.addProduct(new NewProduct("Tablet"));
        manager.addProduct(new ProductAdapter(new LegacyItem("OLD-002", "Old Monitor")));
        manager.addProduct(new NewProduct("Headphones"));
        
        System.out.println("Total Products: " + manager.getInventorySize() + "\n");
        System.out.println("Inventory Contents:");
        System.out.println("─".repeat(50));
        
        java.util.Iterator<Product> iterator = manager.returnInventory();
        while (iterator.hasNext()) {
            System.out.print("• ");
            iterator.next().displayDetails();
        }
    }
}
