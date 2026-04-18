public class TestAdapter {
    public static void main(String[] args) {
        System.out.println("Testing Adapter Pattern:\n");
        
        LegacyItem legacy = new LegacyItem("LEG-100", "Old Keyboard");
        Product adaptedProduct = new ProductAdapter(legacy);
        
        System.out.println("Direct legacy item output (print method):");
        legacy.print();
        
        System.out.println("\nAdapted legacy item output (displayDetails method):");
        adaptedProduct.displayDetails();
        
        System.out.println("\nBoth produce identical output through different interfaces!");
    }
}
