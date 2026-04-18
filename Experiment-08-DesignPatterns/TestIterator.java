import java.util.Iterator;

public class TestIterator {
    public static void main(String[] args) {
        System.out.println("Testing Iterator Pattern:\n");
        
        InventoryManager manager = InventoryManager.getInstance();
        
        manager.addProduct(new NewProduct("Product A"));
        manager.addProduct(new NewProduct("Product B"));
        manager.addProduct(new ProductAdapter(new LegacyItem("L1", "Legacy A")));
        
        System.out.println("Total items: " + manager.getInventorySize());
        System.out.println("\nIterating through inventory:");
        
        Iterator<Product> iterator = manager.returnInventory();
        int count = 1;
        
        while (iterator.hasNext()) {
            System.out.print(count + ". ");
            iterator.next().displayDetails();
            count++;
        }
        
        System.out.println("\nIterator traversal complete!");
    }
}
