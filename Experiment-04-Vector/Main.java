public class Main {
    public static void main(String[] args) {
        try {
            Vector v1 = new Vector(new double[]{1.0, 2.0});
            Vector v2 = new Vector(new double[]{3.0, 4.0});
            System.out.print("v1: ");
            v1.print();
            System.out.print("v2: ");
            v2.print();
            Vector sum = Vector.add(v1, v2);
            System.out.print("v1 + v2: ");
            sum.print();

            Vector diff = Vector.subtract(v1, v2);
            System.out.print("v1 - v2: ");
            diff.print();

            Vector v3 = new Vector(new double[]{1.0, 0.0, -1.0});
            Vector v4 = new Vector(new double[]{2.0, 3.0, 4.0});
            System.out.print("\nv3: ");
            v3.print();
            System.out.print("v4: ");
            v4.print();
            double dot1 = Vector.dotProduct(v3, v4);
            System.out.println("v3 · v4 = " + dot1);

            double selfDot = Vector.dotProduct(v3, v3);
            System.out.println("v3 · v3 = " + selfDot);

        } catch (InvalidVectorSizeException | DimensionMismatchException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            Vector invalidVec = new Vector(new double[]{1, 2, 3, 4});
        } catch (InvalidVectorSizeException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            Vector invalidVec2 = new Vector(new double[]{1});
        } catch (InvalidVectorSizeException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            Vector v1_2d = new Vector(new double[]{1.0, 2.0});
            Vector v3_3d = new Vector(new double[]{1.0, 2.0, 3.0});
            Vector result = Vector.add(v1_2d, v3_3d);
        } catch (InvalidVectorSizeException | DimensionMismatchException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            Vector v1_2d = new Vector(new double[]{5.0, 10.0});
            Vector v3_3d = new Vector(new double[]{1.0, 2.0, 3.0});
            Vector result = Vector.subtract(v1_2d, v3_3d);
        } catch (InvalidVectorSizeException | DimensionMismatchException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            Vector v1_2d = new Vector(new double[]{1.0, 2.0});
            Vector v3_3d = new Vector(new double[]{1.0, 2.0, 3.0});
            double result = Vector.dotProduct(v1_2d, v3_3d);
        } catch (InvalidVectorSizeException | DimensionMismatchException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            Vector v5 = new Vector(new double[]{1.0, 2.0, 3.0});
            Vector v6 = new Vector(new double[]{4.0, 5.0, 6.0});
            System.out.print("\nVector A: ");
            v5.print();
            System.out.print("Vector B: ");
            v6.print();
            Vector sum3d = Vector.add(v5, v6);
            System.out.print("A + B: ");
            sum3d.print();
        } catch (InvalidVectorSizeException | DimensionMismatchException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            Vector v5 = new Vector(new double[]{10.0, 20.0, 30.0});
            Vector v6 = new Vector(new double[]{1.0, 2.0, 3.0});
            System.out.print("Vector X: ");
            v5.print();
            System.out.print("Vector Y: ");
            v6.print();
            Vector diff3d = Vector.subtract(v5, v6);
            System.out.print("X - Y: ");
            diff3d.print();
        } catch (InvalidVectorSizeException | DimensionMismatchException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            Vector v7 = new Vector(new double[]{-1.0, -2.0});
            Vector v8 = new Vector(new double[]{3.0, -4.0});
            System.out.print("\nVector P: ");
            v7.print();
            System.out.print("Vector Q: ");
            v8.print();
            Vector addNeg = Vector.add(v7, v8);
            System.out.print("P + Q: ");
            addNeg.print();
            double dotNeg = Vector.dotProduct(v7, v8);
            System.out.println("P · Q = " + dotNeg);
        } catch (InvalidVectorSizeException | DimensionMismatchException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            Vector zero2d = new Vector(new double[]{0.0, 0.0});
            Vector v9 = new Vector(new double[]{5.0, 10.0});
            System.out.print("Vector zero: ");
            zero2d.print();
            System.out.print("Vector v: ");
            v9.print();
            Vector sumZero = Vector.add(zero2d, v9);
            System.out.print("Result: ");
            sumZero.print();
            double zeroNorm = Vector.dotProduct(v9, zero2d);
            System.out.println("v · zero = " + zeroNorm);
        } catch (InvalidVectorSizeException | DimensionMismatchException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
