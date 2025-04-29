package hus.oop.gk2023_2024.polynomial;


public abstract class AbstractPolynomial implements Polynomial {
    /**
     * Mô tả đa thức theo định dạng [a0 + a1x + a2x^2 + ... + anx^n]
     * @return String mô tả về đa thức.
     */
    @Override
    public String toString() {
        double[] coeffs = coefficients();
        if (coeffs.length == 0) {
            return "0";
        }

        StringBuilder result = new StringBuilder();
        boolean firstTerm = true;

        for (int i = 0; i < coeffs.length; i++) {
            double coeff = coeffs[i];
            if (coeff == 0) {
                continue;
            }

            if (coeff > 0 && !firstTerm) {
                result.append(" + ");
            } else if (coeff < 0) {
                result.append(firstTerm ? "-" : " - ");
                coeff = Math.abs(coeff);
            }

            if (i == 0 || coeff != 1) {
                result.append(coeff);
            }

            if (i > 0) {
                result.append("x");
                if (i > 1) {
                    result.append("^").append(i);
                }
            }

            firstTerm = false;
        }

        return result.toString();
    }

    /**
     * Lấy đạo hàm đa thức.
     * @return mảng các phần tử là hệ số của đa thức đạo hàm.
     */
    public double[] differentiate() {
        double[] coeffs = coefficients();
        if (coeffs.length <= 1) {
            return new double[0]; // Derivative of constant is 0
        }

        double[] derivative = new double[coeffs.length - 1];
        for (int i = 1; i < coeffs.length; i++) {
            derivative[i - 1] = coeffs[i] * i;
        }

        return derivative;
    }
}
