package hus.oop.gkII2425_de2.numbersystem;

import java.util.Random;

public class TestNumberSystem {
    public static void main(String[] args) {
        // Sinh ngẫu nhiên 3 số tự nhiên
        Random random = new Random();
        int n1 = random.nextInt(1000);
        int n2 = random.nextInt(1000);
        int n3 = random.nextInt(1000);

        // Test với số thứ nhất
        testNumberConversion(n1);

        // Test với số thứ hai
        testNumberConversion(n2);

        // Test với số thứ ba
        testNumberConversion(n3);
    }

    private static void testNumberConversion(int number) {
        System.out.println("\nOriginal number: " + number);

        // Tạo đối tượng MyNumber
        MyNumber myNumber = new MyNumber(number);

        // Thêm các converter
        myNumber.addConverter(new BinaryConverter(myNumber));
        myNumber.addConverter(new OctalConverter(myNumber));

        // Kích hoạt chuyển đổi bằng cách set lại số (các converter sẽ tự động update)
        myNumber.setNumber(number);
    }
}