public class TestSingleton {
    public static void main(String[] args) {
        InventoryManager manager1 = InventoryManager.getInstance();
        InventoryManager manager2 = InventoryManager.getInstance();
        
        System.out.println("Testing Singleton Pattern:");
        System.out.println("manager1 reference: " + manager1);
        System.out.println("manager2 reference: " + manager2);
        System.out.println("Are they the same instance? " + (manager1 == manager2));
        
        manager1.addProduct(new NewProduct("Test Product"));
        System.out.println("Product added via manager1");
        System.out.println("Manager2 can access it? Size: " + manager2.getInventorySize());
    }
}
