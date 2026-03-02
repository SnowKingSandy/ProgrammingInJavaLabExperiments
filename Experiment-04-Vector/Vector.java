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

    public static Vector add(Vector v1, Vector v2) throws DimensionMismatchException, InvalidVectorSizeException {
        checkDimensions(v1, v2);
        double[] result = new double[v1.components.length];
        for (int i = 0; i < v1.components.length; i++) {
            result[i] = v1.components[i] + v2.components[i];
        }
        return new Vector(result);
    }

    public static Vector subtract(Vector v1, Vector v2) throws DimensionMismatchException, InvalidVectorSizeException {
        checkDimensions(v1, v2);
        double[] result = new double[v1.components.length];
        for (int i = 0; i < v1.components.length; i++) {
            result[i] = v1.components[i] - v2.components[i];
        }
        return new Vector(result);
    }

    public static double dotProduct(Vector v1, Vector v2) throws DimensionMismatchException {
        checkDimensions(v1, v2);
        double product = 0;
        for (int i = 0; i < v1.components.length; i++) {
            product += (v1.components[i] * v2.components[i]);
        }
        return product;
    }
}
