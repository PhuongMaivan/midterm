package hus.oop.gk2023_2024.polynomial;

public class TestPolynomial {
    public static void main(String[] args) {
        System.out.println("---------- Testing ArrayPolynomial ----------");
        testArrayPolynomial();

        System.out.println("\n---------- Testing ListPolynomial ----------");
        testListPolynomial();

        System.out.println("\n---------- Testing Root Solvers ----------");
        testRootSolver();
    }

    public static void testArrayPolynomial() {
        System.out.println("Creating a new ArrayPolynomial:");
        ArrayPolynomial poly1 = new ArrayPolynomial();
        poly1.insertAtEnd(2);  // 2
        poly1.insertAtEnd(3);  // 3x
        poly1.insertAtEnd(0);  // 0x^2
        poly1.insertAtEnd(1);  // 1x^3

        System.out.println("Polynomial 1: " + poly1);
        System.out.println("Degree: " + poly1.degree());
        System.out.println("Evaluate at x=2: " + poly1.evaluate(2));

        System.out.println("\nInserting at different positions:");
        poly1.insertAtStart(5);  // Add 5 at start
        System.out.println("After insertAtStart(5): " + poly1);

        poly1.insertAtPosition(2, 4);  // Add 4 at position 2
        System.out.println("After insertAtPosition(2, 4): " + poly1);

        System.out.println("\nSetting values:");
        poly1.set(1, 7);  // Change value at index 1 to 7
        System.out.println("After set(1, 7): " + poly1);

        System.out.println("\nCreating a second polynomial:");
        ArrayPolynomial poly2 = new ArrayPolynomial();
        poly2.insertAtEnd(1);  // 1
        poly2.insertAtEnd(2);  // 2x
        poly2.insertAtEnd(1);  // 1x^2
        System.out.println("Polynomial 2: " + poly2);

        System.out.println("\nOperations on polynomials:");
        ArrayPolynomial sum = poly1.plus(poly2);
        System.out.println("Sum of polynomials: " + sum);

        ArrayPolynomial diff = poly1.minus(poly2);
        System.out.println("Difference of polynomials: " + diff);

        ArrayPolynomial product = poly1.multiply(poly2);
        System.out.println("Product of polynomials: " + product);

        System.out.println("\nDerivative:");
        Polynomial derivative = poly1.derivative();
        System.out.println("Derivative of polynomial 1: " + derivative);
    }

    public static void testListPolynomial() {
        System.out.println("Creating a new ListPolynomial:");
        ListPolynomial poly1 = new ListPolynomial();
        poly1.insertAtEnd(2);  // 2
        poly1.insertAtEnd(3);  // 3x
        poly1.insertAtEnd(0);  // 0x^2
        poly1.insertAtEnd(1);  // 1x^3

        System.out.println("Polynomial 1: " + poly1);
        System.out.println("Degree: " + poly1.degree());
        System.out.println("Evaluate at x=2: " + poly1.evaluate(2));

        System.out.println("\nInserting at different positions:");
        poly1.insertAtStart(5);  // Add 5 at start
        System.out.println("After insertAtStart(5): " + poly1);

        poly1.insertAtPosition(2, 4);  // Add 4 at position 2
        System.out.println("After insertAtPosition(2, 4): " + poly1);

        System.out.println("\nSetting values:");
        poly1.set(1, 7);  // Change value at index 1 to 7
        System.out.println("After set(1, 7): " + poly1);

        System.out.println("\nCreating a second polynomial:");
        ListPolynomial poly2 = new ListPolynomial();
        poly2.insertAtEnd(1);  // 1
        poly2.insertAtEnd(2);  // 2x
        poly2.insertAtEnd(1);  // 1x^2
        System.out.println("Polynomial 2: " + poly2);

        System.out.println("\nOperations on polynomials:");
        ListPolynomial sum = poly1.plus(poly2);
        System.out.println("Sum of polynomials: " + sum);

        ListPolynomial diff = poly1.minus(poly2);
        System.out.println("Difference of polynomials: " + diff);

        ListPolynomial product = poly1.multiply(poly2);
        System.out.println("Product of polynomials: " + product);

        System.out.println("\nDerivative:");
        Polynomial derivative = poly1.derivative();
        System.out.println("Derivative of polynomial 1: " + derivative);
    }

    public static void testRootSolver() {
        System.out.println("Testing Bisection Solver:");
        ArrayPolynomial polynomial = new ArrayPolynomial();
        polynomial.insertAtEnd(-6);  // -6
        polynomial.insertAtEnd(11);  // 11x
        polynomial.insertAtEnd(-6);  // -6x^2
        polynomial.insertAtEnd(1);   // 1x^3

        System.out.println("Polynomial: " + polynomial);

        // Bisection Solver
        BisectionSolver bisectionSolver = new BisectionSolver(0.001, 100);
        double rootBisection = bisectionSolver.solve(polynomial, 1, 2);
        System.out.println("Root found using Bisection Method: " + rootBisection);

        // Newton-Raphson Solver
        NewtonRaphsonSolver newtonSolver = new NewtonRaphsonSolver(0.001, 100);
        double rootNewton = newtonSolver.solve(polynomial, 1, 2);
        System.out.println("Root found using Newton-Raphson Method: " + rootNewton);

        // Secant Solver
        SecantSolver secantSolver = new SecantSolver(0.001, 100);
        double rootSecant = secantSolver.solve(polynomial, 1, 2);
        System.out.println("Root found using Secant Method: " + rootSecant);
    }
}
