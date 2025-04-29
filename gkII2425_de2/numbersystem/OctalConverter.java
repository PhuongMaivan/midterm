package hus.oop.gkII2425_de2.numbersystem;

public class OctalConverter extends AbstractNumberConverter {
    public OctalConverter(MyNumber originalNumber) {
        super(originalNumber);
        decimalTo(originalNumber.getNumber());
    }

    /*
     * Chuyển đổi một số được biểu diễn trong hệ cơ số 10
     * sang số được biểu diễn trong hệ cơ số 8.
     * @param decimal
     * @return xâu ký tự biểu diễn số trong hệ cơ số 8.
     *
     * Yêu cầu: sử dụng thuật toán Euclid để chuyển đổi,
     * không sử dụng thư viện chuyển đổi số có sẵn của Java.
     */
    @Override
    public void decimalTo(int decimal) {
        // Xóa dữ liệu cũ trong stack
        convertedNumber = new MyStack();

        // Trường hợp đặc biệt: số 0
        if (decimal == 0) {
            convertedNumber.push(0);
            return;
        }

        // Xử lý số âm
        boolean isNegative = decimal < 0;
        if (isNegative) {
            decimal = -decimal;
        }

        // Chuyển đổi từ hệ 10 sang hệ 8 sử dụng thuật toán Euclid
        while (decimal > 0) {
            int remainder = decimal % 8;
            convertedNumber.push(remainder);
            decimal = decimal / 8;
        }

        // Thêm dấu âm nếu số ban đầu là số âm
        if (isNegative) {
            convertedNumber.push(-1); // Dùng -1 để biểu diễn dấu âm
        }
    }

    /*
     * Cập nhật số được chuyển đổi khi số ban đầu thay đổi
     * hoặc cơ số của số ban đầu thay đổi. Sau đó in ra terminal
     * số được chuyển đổi theo định dạng a1a2...an(8).
     */
    @Override
    public void update() {
        decimalTo(originalNumber.getNumber());
        display();
    }

    /*
     * Hiển thị số ra terminal theo định dạng a1a2...an(8).
     */
    @Override
    public void display() {
        if (convertedNumber.isEmpty()) {
            System.out.println("0(8)");
            return;
        }

        StringBuilder result = new StringBuilder();
        MyStack tempStack = new MyStack();

        // Đảo ngược stack để lấy các chữ số theo thứ tự đúng
        while (!convertedNumber.isEmpty()) {
            tempStack.push(convertedNumber.pop());
        }

        // Kiểm tra dấu âm
        boolean isNegative = false;
        if (!tempStack.isEmpty() && tempStack.peek() == -1) {
            isNegative = true;
            tempStack.pop(); // Loại bỏ dấu âm
        }

        // Thêm dấu trừ nếu là số âm
        if (isNegative) {
            result.append("-");
        }

        // Nối các chữ số vào kết quả
        while (!tempStack.isEmpty()) {
            result.append(tempStack.pop());
        }

        // Hiển thị kết quả
        System.out.println(result.toString() + "(8)");
    }
}