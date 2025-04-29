package hus.oop.gkII2425_de2.book;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class App {
    private static final String COMMA_DELIMITER = ",";
    private static final BookManager bookManager = new BookManager();

    public static void main(String[] args) {
        init();

        System.out.println("=== TEST ORIGINAL DATA ===");
        testOriginalData();

        System.out.println("\n=== TEST SORT INCREASING BY TITLE ===");
        testSortIncreasingTitle();

        System.out.println("\n=== TEST SORT BY PUBLISHER AND PRICE ===");
        testSortPublisherAndPrice();

        System.out.println("\n=== TEST SORT INCREASING BY PRICE ===");
        testPriceOfBooksIncreasing();

        System.out.println("\n=== TEST SORT DECREASING BY PRICE ===");
        testPriceOfBooksDecreasing();

        System.out.println("\n=== TEST FILTER BOOKS OF AUTHOR ===");
        testFilterBooksOfAuthor("J.K. Rowling");

        System.out.println("\n=== TEST FILTER BOOKS OF PUBLISHER ===");
        testFilterBooksOfPublisher("Bloomsbury");

        System.out.println("\n=== TEST FILTER BOOKS OF GENRE ===");
        testFilterBooksOfGenre("Fantasy");

        System.out.println("\n=== TEST TOTAL PAGES ===");
        System.out.println("Total pages: " + testTotalPages());

        System.out.println("\n=== TEST TOTAL PRICE ===");
        System.out.println("Total price: " + testTotalPrice());
    }

    public static void init() {
        // Try to find the data file in a few common locations
        String[] possiblePaths = {"C:/tin cs/Ontapgiuaki/src/data3/books.csv"};

        for (String path : possiblePaths) {
            Path filePath = Paths.get(path);
            if (filePath.toFile().exists()) {
                readListData(filePath.toString());
                return;
            }
        }

        // If no file is found, add some sample data
        addSampleData();
        System.out.println("Warning: Data file not found. Using sample data instead.");
    }

    private static void addSampleData() {
        // Add some sample books in case the data file is not found
        Book book1 = new Book.BookBuilder("Harry Potter and the Philosopher's Stone")
                .withAuthor("J.K. Rowling")
                .withGenre("Fantasy")
                .withPages(223)
                .withPrice(15.99)
                .withPublisher("Bloomsbury")
                .build();

        Book book2 = new Book.BookBuilder("The Hobbit")
                .withAuthor("J.R.R. Tolkien")
                .withGenre("Fantasy")
                .withPages(310)
                .withPrice(12.99)
                .withPublisher("Allen & Unwin")
                .build();

        Book book3 = new Book.BookBuilder("1984")
                .withAuthor("George Orwell")
                .withGenre("Dystopian")
                .withPages(328)
                .withPrice(9.99)
                .withPublisher("Secker & Warburg")
                .build();

        bookManager.append(book1);
        bookManager.append(book2);
        bookManager.append(book3);
    }

    public static void readListData(String filePath) {
        try (BufferedReader dataReader = new BufferedReader(new FileReader(filePath))) {
            String line;

            // Skip header
            dataReader.readLine();

            while ((line = dataReader.readLine()) != null) {
                List<String> dataList = parseDataLineToList(line);
                if (dataList.size() != 6) continue;

                try {
                    Book newBook = new Book.BookBuilder(dataList.get(0))
                            .withAuthor(dataList.get(1))
                            .withGenre(dataList.get(2))
                            .withPages(Integer.parseInt(dataList.get(3)))
                            .withPrice(Double.parseDouble(dataList.get(4)))
                            .withPublisher(dataList.get(5))
                            .build();
                    bookManager.append(newBook);
                } catch (NumberFormatException e) {
                    System.err.println("Error parsing data: " + line + " - " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading data file: " + e.getMessage());
        }
    }

    public static List<String> parseDataLineToList(String dataLine) {
        return Arrays.asList(dataLine.split(COMMA_DELIMITER));
    }

    public static void testOriginalData() {
        BookManager.print(bookManager.sortIncreasingByTitle());
    }

    public static void testSortIncreasingTitle() {
        BookManager.print(bookManager.sortIncreasingByTitle());
    }

    public static void testSortPublisherAndPrice() {
        BookManager.print(bookManager.sortByPublisherAndPrice());
    }

    public static void testPriceOfBooksIncreasing() {
        BookManager.print(bookManager.sortIncreasingPrice());
    }

    public static void testPriceOfBooksDecreasing() {
        BookManager.print(bookManager.sortDecreasingPrice());
    }

    public static void testFilterBooksOfAuthor(String author) {
        BookManager.print(bookManager.filterBooksOfAuthor(author));
    }

    public static void testFilterBooksOfPublisher(String publisher) {
        BookManager.print(bookManager.filterBooksOfPublisher(publisher));
    }

    public static void testFilterBooksOfGenre(String genre) {
        BookManager.print(bookManager.filterBooksOfGenre(genre));
    }

    public static int testTotalPages() {
        return bookManager.totalPages();
    }

    public static double testTotalPrice() {
        return bookManager.totalPrice();
    }
}