package hus.oop.gk2023_2024.bookmanager;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class App {
    private static final String COMMA_DELIMITER = ",";
    private static final BookManager bookManager = new BookManager();

    public static void main(String[] args) {
        init();
        testOriginalData();
        testSortIncreasingTitleAndPrice();
        testSortDecreasingTitleAndPrice();
        testPriceOfBooksIncreasing();
        testPriceOfBooksDecreasing();
        testFilterBooksLowestPrice();
        testFilterBooksHighestPrice();
        testFilterBooksOfAuthor();
        testFilterBooksOfPublisher();
        testFilterBooksOfGenre();
    }

    public static void init() {
        String filePath = "C:/tin cs/Ontapgiuaki/src/data";
        readListData(filePath);
    }

    public static void readListData(String filePath) {
        try (BufferedReader dataReader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = dataReader.readLine()) != null) {
                List<String> dataList = parseDataLineToList(line);
                if (dataList.size() != 6 || dataList.get(0).equals("title")) continue;

                Book newBook = new Book.BookBuilder(dataList.get(0))
                        .withAuthor(dataList.get(1))
                        .withGenre(dataList.get(2))
                        .withPages(Integer.parseInt(dataList.get(3)))
                        .withPrice(Double.parseDouble(dataList.get(4)))
                        .withPublisher(dataList.get(5))
                        .build();
                bookManager.insertAtEnd(newBook);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<String> parseDataLineToList(String dataLine) {
        List<String> result = new ArrayList<>();
        if (dataLine != null) {
            String[] splitData = dataLine.split(COMMA_DELIMITER);
            for (String data : splitData) {
                result.add(data.trim());
            }
        }
        return result;
    }

    public static void testOriginalData() {
        System.out.println("Original Data:");
        BookManager.print(bookManager.getBookList());
    }

    public static void testSortIncreasingTitleAndPrice() {
        System.out.println("\nSorted by title (asc) then price (desc):");
        BookManager.print(bookManager.sortIncreasingTitleAndPrice());
    }

    public static void testSortDecreasingTitleAndPrice() {
        System.out.println("\nSorted by title (desc) then price (desc):");
        BookManager.print(bookManager.sortDecreasingTitleAndPrice());
    }

    public static void testPriceOfBooksIncreasing() {
        System.out.println("\nSorted by price (asc):");
        BookManager.print(bookManager.sortIncreasingPrice());
    }

    public static void testPriceOfBooksDecreasing() {
        System.out.println("\nSorted by price (desc):");
        BookManager.print(bookManager.sortDecreasingPrice());
    }

    public static void testFilterBooksLowestPrice() {
        System.out.println("\nBooks with lowest prices:");
        BookManager.print(bookManager.filterHighestPrice(3));
    }

    public static void testFilterBooksHighestPrice() {
        System.out.println("\nBooks with highest prices:");
        BookManager.print(bookManager.filterHighestPrice(3));
    }

    public static void testFilterBooksOfAuthor() {
        System.out.println("\nBooks by author 'Author A':");
        BookManager.print(bookManager.filterBooksOfAuthor("Author A"));
    }

    public static void testFilterBooksOfPublisher() {
        System.out.println("\nBooks by publisher 'Publisher X':");
        BookManager.print(bookManager.filterBooksOfPublisher("Publisher X"));
    }

    public static void testFilterBooksOfGenre() {
        System.out.println("\nBooks in genre 'Science':");
        BookManager.print(bookManager.filterBooksOfGenre("Science"));
    }
}
