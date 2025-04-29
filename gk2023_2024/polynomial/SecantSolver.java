package hus.oop.gk2023_2024.polynomial;

public class SecantSolver implements RootSolver {
    private double tolerance;
    private int maxIterations;

    /**
     * Khởi tạo giá trị các tham số.
     * @param tolerance
     * @param maxIterations
     */
    public SecantSolver(double tolerance, int maxIterations) {
        this.tolerance = tolerance;
        this.maxIterations = maxIterations;
    }

    /**
     * Tìm nghiệm của đa thức theo phương pháp Secant
     * @param polynomial
     * @param lower
     * @param upper
     * @return nghiệm của đa thức trong khoảng [lower, upper]
     */
    @Override
    public double solve(Polynomial polynomial, double lower, double upper) {
        double x0 = lower;
        double x1 = upper;
        double f0 = polynomial.evaluate(x0);
        double f1 = polynomial.evaluate(x1);

        // Check if either endpoint is already a root
        if (Math.abs(f0) < tolerance) return x0;
        if (Math.abs(f1) < tolerance) return x1;

        for (int i = 0; i < maxIterations; i++) {
            // Check for division by zero or very small difference
            if (Math.abs(f1 - f0) < 1e-10) {
                // Try a different approach or pick a new starting point
                x0 = (lower + x1) / 2;
                f0 = polynomial.evaluate(x0);
                continue;
            }

            // Secant method formula: x_new = x1 - f1 * (x1 - x0) / (f1 - f0)
            double x2 = x1 - f1 * (x1 - x0) / (f1 - f0);

            // Check if we're converging
            if (Math.abs(x2 - x1) < tolerance) {
                return x2;
            }

            // Shift values for next iteration
            x0 = x1;
            f0 = f1;
            x1 = x2;
            f1 = polynomial.evaluate(x1);

            // Check if we found a root
            if (Math.abs(f1) < tolerance) {
                return x1;
            }
        }

        return x1; // Return best estimate after maxIterations
    }
}