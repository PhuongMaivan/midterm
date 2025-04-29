package hus.oop.gk2023_2024.polynomial;

public class BisectionSolver implements RootSolver {
    private double tolerance;
    private int maxIterations;

    /**
     * Khởi tạo giá trị các tham số.
     * @param tolerance
     * @param maxIterations
     */
    public BisectionSolver(double tolerance, int maxIterations) {
        this.tolerance = tolerance;
        this.maxIterations = maxIterations;
    }

    /**
     * Tìm nghiệm của đa thức theo phương pháp chia đôi (Bisection)
     * @param polynomial
     * @param lower
     * @param upper
     * @return
     */
    @Override
    public double solve(Polynomial polynomial, double lower, double upper) {
        double a = lower;
        double b = upper;
        double fa = polynomial.evaluate(a);
        double fb = polynomial.evaluate(b);

        // Check if there's a root in the interval
        if (fa * fb > 0) {
            throw new IllegalArgumentException("Function must have opposite signs at interval endpoints");
        }

        double c = a;
        double fc = fa;

        for (int i = 0; i < maxIterations; i++) {
            // Calculate midpoint
            c = (a + b) / 2;
            fc = polynomial.evaluate(c);

            // Check if we've found the root within tolerance
            if (Math.abs(fc) < tolerance || (b - a) / 2 < tolerance) {
                return c;
            }

            // Update interval
            if (fa * fc < 0) {
                b = c;
                fb = fc;
            } else {
                a = c;
                fa = fc;
            }
        }

        return c; // Return best estimate after maxIterations
    }
}