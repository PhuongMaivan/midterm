package hus.oop.numbersystem;

import java.math.BigInteger;

public class HexadecimalConverter extends AbstractNumberConverter {
    public HexadecimalConverter(OriginalNumber originalNumber) {
        /* TODO */
        super(originalNumber);
    }

    /**
     * Chuyển đổi một số được biểu diễn trong hệ cơ số 10
     * sang số được biểu diễn trong hệ cơ số 16.
     * @param decimal
     * @return xâu ký tự biểu diễn số trong hệ cơ số 16.
     *
     * Yêu cầu: sử dụng thuật toán Euclid để chuyển đổi,
     * không sử dụng thư viện chuyển đổi số có sẵn của Java.
     */
    @Override
    public String decimalTo(String decimal) {
        /* TODO */
        BigInteger dec = new BigInteger(decimal);
        if (dec.compareTo(BigInteger.TEN) < 0) {
            return decimal;
        } else if (dec.compareTo(
                new BigInteger("16")) < 0) {
            return Character.toString(
                    (char) Integer.parseInt(decimal)
                            - 10 + 'A');
        }
        BigInteger a = dec.divide(new BigInteger("16"));
        BigInteger b = dec.divideAndRemainder(
                new BigInteger("16"))[1];
        return decimalTo(a.toString()) + decimalTo(b.toString());
    }



    /**
     * Cập nhật số được chuyển đổi khi số ban đầu thay đổi
     * hoặc cơ số của số ban đầu thay đổi. Sau đó in ra terminal 
     * số được chuyển đổi theo định dạng a1a2...an(16).
     */
    @Override
    public void update() {
        /* TODO */
        String dec = toDecimal();
        convertedNumber = decimalTo(dec);
        display();
    }

    /**
     * Hiển thị số ra terminal theo định dạng a1a2...an(16).
     */
    @Override
    public void display() {
        /* TODO */
        System.out.println("Hexadecimal: " + convertedNumber);
    }
}
