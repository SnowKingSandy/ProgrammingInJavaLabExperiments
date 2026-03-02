public class Vector {
    public double[] components;

    public Vector(double[] components) throws InvalidVectorSizeException {
        if (components.length != 2 && components.length != 3) {
            throw new InvalidVectorSizeException("Invalid Size: Vector must be 2D or 3D.");
        }
        this.components = components;
    }

    public void print() {
        System.out.print("(");
        for (int i = 0; i < components.length; i++) {
            System.out.print(components[i] + (i < components.length - 1 ? ", " : ""));
        }
        System.out.println(")");
    }

    public static void checkDimensions(Vector v1, Vector v2) throws DimensionMismatchException {
        if (v1.components.length != v2.components.length) {
            throw new DimensionMismatchException("Dimension Mismatch: Vectors must be of the same size.");
        }
    }
}
