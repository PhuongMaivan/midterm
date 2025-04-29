package hus.oop.gk2023_2024.polynomial;

import java.util.Arrays;

public class ArrayPolynomial extends AbstractPolynomial {
    private static final int DEFAULT_CAPACITY = 8;
    private double[] coefficents;
    private int size;

    /**
     * Khởi tạo dữ liệu mặc định.
     */
    public ArrayPolynomial() {
        coefficents = new double[DEFAULT_CAPACITY];
        size = 0;
    }

    /**
     * Lấy hệ số của đa thức tại phần tử index
     * @return hệ số tại phần tử index.
     */
    @Override
    public double coefficientAt(int index) {
        if (index < 0 || index >= size) {
            return 0;
        }
        return coefficents[index];
    }

    /**
     * Lấy mảng các hệ số của đa thức.
     * @return mảng các hệ số của đa thức.
     */
    @Override
    public double[] coefficients() {
        return Arrays.copyOf(coefficents, size);
    }

    /**
     * Thêm một phần tử có hệ số coefficient vào đầu đa thức.
     * @param coefficient
     * @return đa thức hiện tại.
     */
    public void insertAtStart(double coefficient) {
        if (size >= coefficents.length) {
            allocateMore();
        }

        // Shift all elements one position to the right
        for (int i = size; i > 0; i--) {
            coefficents[i] = coefficents[i - 1];
        }

        coefficents[0] = coefficient;
        size++;
    }

    /**
     * Thêm một phần tử có hệ số coefficient vào cuối đa thức.
     * @param coefficient
     * @return đa thức hiện tại.
     */
    public void insertAtEnd(double coefficient) {
        if (size >= coefficents.length) {
            allocateMore();
        }

        coefficents[size] = coefficient;
        size++;
    }

    /**
     * Thêm một phần tử có hệ số coefficient vào vị trí index.
     * @param coefficient
     * @param index
     * @return đa thức hiện tại.
     */
    public void insertAtPosition(int index, double coefficient) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Invalid index: " + index);
        }

        if (index == 0) {
            insertAtStart(coefficient);
            return;
        }

        if (index == size) {
            insertAtEnd(coefficient);
            return;
        }

        if (size >= coefficents.length) {
            allocateMore();
        }

        // Shift elements to make room for new element
        for (int i = size; i > index; i--) {
            coefficents[i] = coefficents[i - 1];
        }

        coefficents[index] = coefficient;
        size++;
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

        // If setting beyond current size, expand the array
        if (index >= size) {
            while (index >= coefficents.length) {
                allocateMore();
            }
            size = index + 1;
        }

        coefficents[index] = coefficient;
    }

    /**
     * Lấy bậc của đa thức.
     * @return bậc của đa thức.
     */
    @Override
    public int degree() {
        // Find the highest power with non-zero coefficient
        for (int i = size - 1; i >= 0; i--) {
            if (coefficents[i] != 0) {
                return i;
            }
        }
        return 0; // Zero polynomial
    }

    /**
     * Tính giá trị của đa thức khi biết giá trị của x.
     * @return giá trị của đa thức.
     */
    @Override
    public double evaluate(double x) {
        double result = 0;
        double power = 1; // x^0 = 1

        for (int i = 0; i < size; i++) {
            result += coefficents[i] * power;
            power *= x; // For the next iteration, power = x^(i+1)
        }

        return result;
    }

    /**
     * Lấy đạo hàm của đa thức.
     * @return Đa thức kiểu ArrayPolynomial là đa thức đạo hàm của đa thức hiện tại.
     */
    @Override
    public Polynomial derivative() {
        ArrayPolynomial derivative = new ArrayPolynomial();

        if (size <= 1) {
            return derivative; // Derivative of constant is 0
        }

        for (int i = 1; i < size; i++) {
            derivative.insertAtEnd(coefficents[i] * i);
        }

        return derivative;
    }

    /**
     * Cộng một đa thức khác vào đa thức hiện tại.
     * @param another
     * @return đa thức hiện tại.
     */
    public ArrayPolynomial plus(ArrayPolynomial another) {
        ArrayPolynomial result = new ArrayPolynomial();
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
    public ArrayPolynomial minus(ArrayPolynomial another) {
        ArrayPolynomial result = new ArrayPolynomial();
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
    public ArrayPolynomial multiply(ArrayPolynomial another) {
        ArrayPolynomial result = new ArrayPolynomial();
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

    /**
     * Thêm kích thước mảng gấp đôi để lưu đa thức.
     */
    private void allocateMore() {
        double[] newCoefficients = new double[coefficents.length * 2];
        System.arraycopy(coefficents, 0, newCoefficients, 0, size);
        coefficents = newCoefficients;
    }
}