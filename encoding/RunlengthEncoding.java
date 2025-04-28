package hus.oop.encoding;

public class RunlengthEncoding {
    public static void main(String[] args) {
        testEncoding();
        System.out.println();
        testDecoding();
    }

    /*
     * Hàm mã hóa chuỗi ký tự text theo mã hóa run-length.
     */
    public static String encoding(String text) {
        if (text == null || text.isEmpty()) {
            return "";
        }

        StringBuilder result = new StringBuilder();
        int count = 1;
        char current = text.charAt(0);

        for (int i = 1; i < text.length(); i++) {
            if (text.charAt(i) == current) {
                count++;
            } else {
                result.append(count).append(current);
                current = text.charAt(i);
                count = 1;
            }
        }

        // Thêm ký tự cuối cùng và số lần xuất hiện
        result.append(count).append(current);
        return result.toString();
    }

    /*
     * Hàm giải mã chuỗi ký tự text theo mã hóa run-length.
     */
    public static String decoding(String text) {
        if (text == null || text.isEmpty()) {
            return "";
        }

        StringBuilder result = new StringBuilder();
        int i = 0;

        while (i < text.length()) {
            // Đọc số lần lặp lại
            StringBuilder countStr = new StringBuilder();
            while (i < text.length() && Character.isDigit(text.charAt(i))) {
                countStr.append(text.charAt(i));
                i++;
            }

            int count = Integer.parseInt(countStr.toString());

            // Đọc ký tự
            if (i < text.length()) {
                char ch = text.charAt(i);
                // Thêm ký tự vào kết quả theo số lần lặp lại
                for (int j = 0; j < count; j++) {
                    result.append(ch);
                }
                i++;
            }
        }

        return result.toString();
    }

    /*
     * Hàm test mã hóa theo mã hóa run-length.
     */
    public static void testEncoding() {
        String[] testStrings = {
                "aaaaabcccaa",
                "AAAABBBCCDAA",
                "abcdefg",
                "zzzzzzzzzzz",
                "aabbbcccddeeeefffff"
        };

        System.out.println("Test mã hóa run-length:");
        for (String test : testStrings) {
            String encoded = encoding(test);
            System.out.println("Decoded Text: " + test);
            System.out.println("Encoded Text: " + encoded);
            System.out.println();
        }
    }

    /*
     * Hàm test giải mã theo mã hóa run-length.
     */
    public static void testDecoding() {
        String[] testStrings = {
                "5a1b3c2a",
                "4A3B2C1D2A",
                "1a1b1c1d1e1f1g",
                "11z",
                "2a3b3c2d2e5f"
        };

        System.out.println("Test giải mã run-length:");
        for (String test : testStrings) {
            String decoded = decoding(test);
            System.out.println("Encoded Text: " + test);
            System.out.println("Decoded Text: " + decoded);
            System.out.println();
        }
    }
}