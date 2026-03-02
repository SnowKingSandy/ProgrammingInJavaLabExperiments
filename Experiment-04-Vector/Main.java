public class Main {
    public static void main(String[] args) {
        try {
            // Test 1: Successful 2D Operation - Addition
            System.out.println("=== Test 1: 2D Vector Addition ===");
            Vector v1 = new Vector(new double[]{1.0, 2.0});
            Vector v2 = new Vector(new double[]{3.0, 4.0});
            System.out.print("Vector 1: ");
            v1.print();
            System.out.print("Vector 2: ");
            v2.print();
            Vector sum = Vector.add(v1, v2);
            System.out.print("Sum: ");
            sum.print();

            // Test 2: Successful 2D Operation - Subtraction
            System.out.println("\n=== Test 2: 2D Vector Subtraction ===");
            Vector diff = Vector.subtract(v1, v2);
            System.out.print("Difference (v1 - v2): ");
            diff.print();

            // Test 3: Successful 3D Operation - Dot Product
            System.out.println("\n=== Test 3: 3D Vector Dot Product ===");
            Vector v3 = new Vector(new double[]{1.0, 0.0, -1.0});
            Vector v4 = new Vector(new double[]{2.0, 3.0, 4.0});
            System.out.print("Vector 3D (A): ");
            v3.print();
            System.out.print("Vector 3D (B): ");
            v4.print();
            double dot1 = Vector.dotProduct(v3, v4);
            System.out.println("Dot Product (A · B): " + dot1);

            // Test 4: Self dot product (magnitude squared)
            System.out.println("\n=== Test 4: Self Dot Product (Magnitude Squared) ===");
            double selfDot = Vector.dotProduct(v3, v3);
            System.out.println("v3 · v3 = " + selfDot);

        } catch (InvalidVectorSizeException | DimensionMismatchException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            // Test 5: Invalid Vector Size Exception (Size 4)
            System.out.println("\n=== Test 5: Invalid Vector Size (4D) ===");
            Vector invalidVec = new Vector(new double[]{1, 2, 3, 4});

        } catch (InvalidVectorSizeException e) {
            System.out.println("Caught Expected Error: " + e.getMessage());
        }

        try {
            // Test 6: Invalid Vector Size Exception (Size 1)
            System.out.println("\n=== Test 6: Invalid Vector Size (1D) ===");
            Vector invalidVec2 = new Vector(new double[]{1});

        } catch (InvalidVectorSizeException e) {
            System.out.println("Caught Expected Error: " + e.getMessage());
        }

        try {
            // Test 7: Dimension Mismatch (2D + 3D) - Addition
            System.out.println("\n=== Test 7: Dimension Mismatch - Addition (2D + 3D) ===");
            Vector v1_2d = new Vector(new double[]{1.0, 2.0});
            Vector v3_3d = new Vector(new double[]{1.0, 2.0, 3.0});
            Vector result = Vector.add(v1_2d, v3_3d);

        } catch (InvalidVectorSizeException | DimensionMismatchException e) {
            System.out.println("Caught Expected Error: " + e.getMessage());
        }

        try {
            // Test 8: Dimension Mismatch (2D - 3D) - Subtraction
            System.out.println("\n=== Test 8: Dimension Mismatch - Subtraction (2D - 3D) ===");
            Vector v1_2d = new Vector(new double[]{5.0, 10.0});
            Vector v3_3d = new Vector(new double[]{1.0, 2.0, 3.0});
            Vector result = Vector.subtract(v1_2d, v3_3d);

        } catch (InvalidVectorSizeException | DimensionMismatchException e) {
            System.out.println("Caught Expected Error: " + e.getMessage());
        }

        try {
            // Test 9: Dimension Mismatch - Dot Product
            System.out.println("\n=== Test 9: Dimension Mismatch - Dot Product (2D · 3D) ===");
            Vector v1_2d = new Vector(new double[]{1.0, 2.0});
            Vector v3_3d = new Vector(new double[]{1.0, 2.0, 3.0});
            double result = Vector.dotProduct(v1_2d, v3_3d);

        } catch (InvalidVectorSizeException | DimensionMismatchException e) {
            System.out.println("Caught Expected Error: " + e.getMessage());
        }

        try {
            // Test 10: 3D Vector Operations - Addition
            System.out.println("\n=== Test 10: 3D Vector Addition ===");
            Vector v5 = new Vector(new double[]{1.0, 2.0, 3.0});
            Vector v6 = new Vector(new double[]{4.0, 5.0, 6.0});
            System.out.print("Vector A: ");
            v5.print();
            System.out.print("Vector B: ");
            v6.print();
            Vector sum3d = Vector.add(v5, v6);
            System.out.print("Sum: ");
            sum3d.print();

        } catch (InvalidVectorSizeException | DimensionMismatchException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            // Test 11: 3D Vector Operations - Subtraction
            System.out.println("\n=== Test 11: 3D Vector Subtraction ===");
            Vector v5 = new Vector(new double[]{10.0, 20.0, 30.0});
            Vector v6 = new Vector(new double[]{1.0, 2.0, 3.0});
            System.out.print("Vector A: ");
            v5.print();
            System.out.print("Vector B: ");
            v6.print();
            Vector diff3d = Vector.subtract(v5, v6);
            System.out.print("Difference: ");
            diff3d.print();

        } catch (InvalidVectorSizeException | DimensionMismatchException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            // Test 12: Edge case with negative values
            System.out.println("\n=== Test 12: Vectors with Negative Values ===");
            Vector v7 = new Vector(new double[]{-1.0, -2.0});
            Vector v8 = new Vector(new double[]{3.0, -4.0});
            System.out.print("Vector A: ");
            v7.print();
            System.out.print("Vector B: ");
            v8.print();
            Vector addNeg = Vector.add(v7, v8);
            System.out.print("Sum: ");
            addNeg.print();
            double dotNeg = Vector.dotProduct(v7, v8);
            System.out.println("Dot Product: " + dotNeg);

        } catch (InvalidVectorSizeException | DimensionMismatchException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            // Test 13: Zero vectors
            System.out.println("\n=== Test 13: Zero Vectors ===");
            Vector zero2d = new Vector(new double[]{0.0, 0.0});
            Vector v9 = new Vector(new double[]{5.0, 10.0});
            System.out.print("Zero Vector (2D): ");
            zero2d.print();
            System.out.print("Vector: ");
            v9.print();
            Vector sumZero = Vector.add(zero2d, v9);
            System.out.print("Sum: ");
            sumZero.print();
            double zeroNorm = Vector.dotProduct(v9, zero2d);
            System.out.println("v · zero = " + zeroNorm);

        } catch (InvalidVectorSizeException | DimensionMismatchException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\n=== All Tests Completed ===");
    }
}
