package hus.oop.gk2023_2024.polynomial;

import java.util.ArrayList;
import java.util.List;

public class ListPolynomial extends AbstractPolynomial {
    private List<Double> coefficients;

    /**
     * Khởi tạo dữ liệu mặc định.
     */
    public ListPolynomial() {
        coefficients = new ArrayList<>();
    }

    /**
     * Lấy hệ số của đa thức tại vị trí index.
     * @return
     */
    @Override
    public double coefficientAt(int index) {
        if (index < 0 || index >= coefficients.size()) {
            return 0;
        }
        return coefficients.get(index);
    }

    /**
     * Lấy các hệ số của đa thức.
     * @return mảng các hệ số của đa thức
     */
    @Override
    public double[] coefficients() {
        double[] result = new double[coefficients.size()];
        for (int i = 0; i < coefficients.size(); i++) {
            result[i] = coefficients.get(i);
        }
        return result;
    }

    /**
     * Thêm một phần tử có hệ số coefficient vào đầu đa thức.
     * @param coefficient
     * @return đa thức hiện tại.
     */
    public void insertAtStart(double coefficient) {
        coefficients.add(0, coefficient);
    }

    /**
     * Thêm một phần tử có hệ số coefficient vào cuối đa thức.
     * @param coefficient
     * @return đa thức hiện tại.
     */
    public void insertAtEnd(double coefficient) {
        coefficients.add(coefficient);
    }

    /**
     * Thêm một phần tử có hệ số coefficient vào vị trí index.
     * @param coefficient
     * @param index
     * @return đa thức hiện tại.
     */
    public void insertAtPosition(int index, double coefficient) {
        if (index < 0 || index > coefficients.size()) {
            throw new IllegalArgumentException("Invalid index: " + index);
        }

        coefficients.add(index, coefficient);
    }

    /**
     * Thay đổi hệ số của đa thức tại phần tử index.
     * @param coefficient
     * @param index
     * @return đa thức hiện tại.
     */
    public void set(int index, double coefficient) {
        if (index < 0) {
            throw new IllegalArgumentException("Invalid index: " + index);
        }

        // If setting beyond current size, expand the list
        while (index >= coefficients.size()) {
            coefficients.add(0.0);
        }

        coefficients.set(index, coefficient);
    }

    /**
     * Lấy ra bậc của đa thức.
     * @return
     */
    @Override
    public int degree() {
        // Find the highest power with non-zero coefficient
        for (int i = coefficients.size() - 1; i >= 0; i--) {
            if (coefficients.get(i) != 0) {
                return i;
            }
        }
        return 0; // Zero polynomial
    }

    /**
     * Tính giá trị của đa thức khi biết giá trị của x.
     * @return
     */
    @Override
    public double evaluate(double x) {
        double result = 0;
        double power = 1; // x^0 = 1

        for (int i = 0; i < coefficients.size(); i++) {
            result += coefficients.get(i) * power;
            power *= x; // For the next iteration, power = x^(i+1)
        }

        return result;
    }

    /**
     * Lấy đạo hàm của đa thức.
     * @return Đa thức kiểu ListPolynomial là đa thức đạo hàm của đa thức ban đầu.
     */
    @Override
    public Polynomial derivative() {
        ListPolynomial derivative = new ListPolynomial();

        if (coefficients.size() <= 1) {
            return derivative; // Derivative of constant is 0
        }

        for (int i = 1; i < coefficients.size(); i++) {
            derivative.insertAtEnd(coefficients.get(i) * i);
        }

        return derivative;
    }

    /**
     * Cộng đa thức hiện tại với đa thức khác.
     * @param another
     * @return đa thức hiện tại.
     */
    public ListPolynomial plus(ListPolynomial another) {
        ListPolynomial result = new ListPolynomial();
        int maxDegree = Math.max(this.degree(), another.degree());

        for (int i = 0; i <= maxDegree; i++) {
            double sum = this.coefficientAt(i) + another.coefficientAt(i);
            result.insertAtEnd(sum);
        }

        return result;
    }

    /**
     * Trừ đa thức hiện tại với đa thức khác.
     * @param another
     * @return đa thức hiện tại.
     */
    public ListPolynomial minus(ListPolynomial another) {
        ListPolynomial result = new ListPolynomial();
        int maxDegree = Math.max(this.degree(), another.degree());

        for (int i = 0; i <= maxDegree; i++) {
            double diff = this.coefficientAt(i) - another.coefficientAt(i);
            result.insertAtEnd(diff);
        }

        return result;
    }

    /**
     * Nhân đa thức hiện tại với đa thức khác.
     * @param another
     * @return đa thức hiện tại.
     */
    public ListPolynomial multiply(ListPolynomial another) {
        ListPolynomial result = new ListPolynomial();
        int resultDegree = this.degree() + another.degree();

        // Initialize result with zeros
        for (int i = 0; i <= resultDegree; i++) {
            result.insertAtEnd(0);
        }

        // Multiply each term of this polynomial with each term of the other
        for (int i = 0; i <= this.degree(); i++) {
            for (int j = 0; j <= another.degree(); j++) {
                double product = this.coefficientAt(i) * another.coefficientAt(j);
                double currentValue = result.coefficientAt(i + j);
                result.set(i + j, currentValue + product);
            }
        }

        return result;
    }
}