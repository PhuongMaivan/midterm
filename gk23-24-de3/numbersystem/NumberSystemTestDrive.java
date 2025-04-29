package hus.oop.numbersystem;

public class NumberSystemTestDrive {
    public static void main(String[] args) {
        /* Yêu cầu:

        - Sinh ngẫu nhiên 3 số bằng cách:
            - Cơ số radix là một số tự nhiên nằm trong đoạn [2, 16] được sinh ngẫu nhiên.
            - Xâu ký tự biểu diễn số được sinh ra bằng cách:
                + Độ dài số là một số tự nhiên nằm trong đoạn [10, 30] được sinh ra ngẫu nhiên.
                + Mỗi chữ số được sinh ra bằng cách: sinh ra một chỉ số ngẫu nhiên nằm trong đoạn [0, radix - 1],
                  sau đó lấy tương ứng với chỉ số đó một chữ số nằm trong xâu "0123456789ABCDEF".

        - Mỗi lần sinh ra một số và một cơ số mới, thực hiện việc cập nhật và in ra các số được chuyển đổi
          tự động sang các số được biểu diễn trong hệ cơ số 2, 8, 16.

        - Thực hiện chạy chương trình để in ra terminal thông tin về các số ban đầu và các số chuyển đổi, ví dụ:
          Original number: 123456
          radix 12
          Binary: 1111111
          Octal: 7777777
          Hexadecimal: FFFFFF

          Original number: 456789
          radix 7
          Binary: 1111111
          Octal: 7777777
          Hexadecimal: FFFFFF

          Lưu kết quả chạy chương trình và file text được đặt tên
          là <TenSinhVien_MaSinhVien_NumberSystemConverter>.txt (Ví dụ, NguyenVanA_123456_NumberSystemConverter.txt).
        - Nén các file source code và file text kết quả chạy chương trình vào file zip có tên
          <TenSinhVien_MaSinhVien_NumberSystemConverter>.zip (Ví dụ, NguyenVanA_123456_NumberSystemConverter.zip),
          nộp lên classroom.
         */
        NumberSystemTestDrive test = new NumberSystemTestDrive();
        int radix1 = test.generateRadix();
        String num1 = test.generateRadixString(radix1);
        OriginalNumber number = new OriginalNumber(num1, radix1);
        number.addConverter(new BinaryConverter(number));
        number.addConverter(new OctalConverter(number));
        number.addConverter(new HexadecimalConverter(number));

        System.out.println("Original Number: " + num1);
        System.out.println("Radix Number: " + radix1);
        number.setNumberPresentation(num1);
        System.out.println();

        System.out.println("Original Number: " + 123456);
        System.out.println("Radix Number: " + radix1);
        number.setNumberPresentation("123456");
        System.out.println();

        System.out.println("Original Number: " + 123456);
        System.out.println("Radix Number: " + 12);
        number.setRadix(12);
        System.out.println();
    }

    public int generateRadix() {
        return  2 + ((int) (Math.random() * 15));
    }

    public String generateRadixString(int radix) {
        int length = 10 + ((int) (Math.random() * 21));
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int number = (int) (Math.random() * radix);
            if (number < 10) {
                builder.append(number);
            } else {
                builder.append((char) (number + 55));
            }
        }
        return builder.toString();
    }
}
