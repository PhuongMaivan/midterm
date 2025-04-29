package hus.oop.gk2023_2024.polynomial;

public class PolynomialRootFinding {
    private Polynomial poly;
    private RootSolver rootSolver;

    /**
     * Khởi tạo đa thức.
     * @param polynomial
     */
    public PolynomialRootFinding(Polynomial polynomial) {
        this.poly = polynomial;
        // Default to bisection method with reasonable defaults
        this.rootSolver = new BisectionSolver(1e-10, 1000);
    }

    /**
     * Khởi tạo đa thức và phương pháp tìm nghiệm.
     * @param polynomial
     * @param rootSolver
     */
    public PolynomialRootFinding(Polynomial polynomial, RootSolver rootSolver) {
        this.poly = polynomial;
        this.rootSolver = rootSolver;
    }

    public void setPoly(Polynomial poly) {
        this.poly = poly;
    }

    public void setRootSolver(RootSolver rootSolver) {
        this.rootSolver = rootSolver;
    }

    /**
     * Tìm nghiệm của đa thức theo phương pháp đã cho.
     * @param lower
     * @param upper
     * @return
     */
    public double solve(double lower, double upper) {
        if (poly == null) {
            throw new IllegalStateException("Polynomial has not been set");
        }
        if (rootSolver == null) {
            throw new IllegalStateException("Root solver has not been set");
        }
        return rootSolver.solve(poly, lower, upper);
    }
}