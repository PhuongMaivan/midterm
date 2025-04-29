package hus.oop.gk2023_2024.polynomial;

public class NewtonRaphsonSolver implements RootSolver {
    private double tolerance;
    private int maxIterations;

    /**
     * Khởi tạo giá trị các tham số.
     * @param tolerance
     * @param maxIterations
     */
    public NewtonRaphsonSolver(double tolerance, int maxIterations) {
        this.tolerance = tolerance;
        this.maxIterations = maxIterations;
    }

    /**
     * Tìm nghiệm của đa thức sử dụng phương pháp Newton-Raphson.
     * @param polynomial
     * @param lower
     * @param upper
     * @return nghiệm của đa thức.
     */
    @Override
    public double solve(Polynomial polynomial, double lower, double upper) {
        // Start at midpoint of interval
        double x = (lower + upper) / 2;

        // Get derivative polynomial
        Polynomial derivative = polynomial.derivative();

        for (int i = 0; i < maxIterations; i++) {
            double fx = polynomial.evaluate(x);

            // Check if we've found the root within tolerance
            if (Math.abs(fx) < tolerance) {
                return x;
            }

            double fpx = derivative.evaluate(x);

            // Check for division by zero (flat derivative)
            if (Math.abs(fpx) < 1e-10) {
                // If derivative is close to zero, try a different approach
                // or pick a new starting point
                x = (x + upper) / 2;
                continue;
            }

            // Newton-Raphson step: x = x - f(x)/f'(x)
            double nextX = x - fx / fpx;

            // Check if the value is converging
            if (Math.abs(nextX - x) < tolerance) {
                return nextX;
            }

            // Check if new point is within bounds
            if (nextX < lower || nextX > upper) {
                // If out of bounds, bisect the interval
                x = (lower + upper) / 2;
            } else {
                x = nextX;
            }
        }

        return x; // Return best estimate after maxIterations
    }
}