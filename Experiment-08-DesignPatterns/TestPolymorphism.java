import java.util.ArrayList;
import java.util.List;

public class TestPolymorphism {
    public static void main(String[] args) {
        System.out.println("Testing Polymorphism with Product Interface:\n");
        
        List<Product> products = new ArrayList<>();
        
        products.add(new NewProduct("Modern Laptop"));
        products.add(new ProductAdapter(new LegacyItem("LEGACY-99", "Ancient Equipment")));
        products.add(new NewProduct("Fast Mouse"));
        
        System.out.println("Processing " + products.size() + " products:");
        System.out.println("─".repeat(50));
        
        for (Product product : products) {
            System.out.print("→ Type: " + product.getClass().getSimpleName() + " | ");
            product.displayDetails();
        }
    }
}
