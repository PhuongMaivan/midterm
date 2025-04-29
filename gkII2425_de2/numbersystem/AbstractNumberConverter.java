package hus.oop.gkII2425_de2.numbersystem;

public abstract class AbstractNumberConverter implements NumberConverter {
    protected MyNumber originalNumber;   // Số gốc
    protected MyStack convertedNumber;   // Số được chuyển đổi theo cơ số nào đó từ số gốc

    public AbstractNumberConverter(MyNumber originalNumber) {
        this.originalNumber = originalNumber;
        this.convertedNumber = new MyStack();
        originalNumber.addConverter(this);
    }

    /*
     * Chuyển đổi số decimal từ hệ cơ số 10 thành số có hệ cơ số nào đó.
     * @param decimal
     * @return xâu ký tự biểu diễn một số trong hệ cơ số nào đó.
     *
     * Yêu cầu: sử dụng thuật toán Euclid để chuyển đổi,
     * không sử dụng thư viện chuyển đổi số có sẵn của Java.
     *
     * Gợi ý: có thể sử dụng lớp trung gian BigInteger để thuận lợi hơn cho việc tính toán.
     */
    public abstract void decimalTo(int decimal);
}