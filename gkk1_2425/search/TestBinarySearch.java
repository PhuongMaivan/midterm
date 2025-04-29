package hus.oop.gkk1_2425.search;

import java.util.Random;
import java.util.Arrays;

public class TestBinarySearch {
    public static void main(String[] args) {
        Random random = new Random();
        int size = 10 + random.nextInt(11); // Số ngẫu nhiên từ 10-20
        double[] data = new double[size];

        // Tạo mảng ngẫu nhiên
        for (int i = 0; i < size; i++) {
            data[i] = Math.round(random.nextDouble() * 100 * 10) / 10.0;
        }

        // Giá trị cần tìm kiếm
        double searchValue = Math.round(random.nextDouble() * 100 * 10) / 10.0;

        // Test với BubbleSort
        testWithSorter(data.clone(), searchValue, "Bubble Sort", new BubbleSort());

        // Test với InsertionSort
        testWithSorter(data.clone(), searchValue, "Insertion Sort", new InsertionSort());

        // Test với SelectionSort
        testWithSorter(data.clone(), searchValue, "Selection Sort", new SelectionSort());
    }

    private static void testWithSorter(double[] data, double value, String sortName, Sorter sorter) {
        System.out.println("Using " + sortName + " Algorithm:");
        System.out.println("Before sorting: " + Arrays.toString(data));

        BinarySearch binarySearch = new BinarySearch();
        binarySearch.setSorter(sorter);
        binarySearch.search(data, value); // Sắp xếp mảng

        System.out.println("After sorting: " + Arrays.toString(data));

        int result = binarySearch.search(data, value);
        System.out.println("Binary search giá trị " + value + ": " + result);
        System.out.println();
    }
}