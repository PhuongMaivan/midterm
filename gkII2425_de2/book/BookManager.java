package hus.oop.gkII2425_de2.book;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class BookManager {
    private List<Book> bookList;

    public BookManager() {
        this.bookList = new ArrayList<>();
    }

    public void append(Book book) {
        bookList.add(book);
    }

    public void insertAtPosition(Book book, int index) {
        if (index >= 0 && index <= bookList.size()) {
            bookList.add(index, book);
        }
    }

    public void remove(int index) {
        if (index >= 0 && index < bookList.size()) {
            bookList.remove(index);
        }
    }

    public Book bookAt(int index) {
        if (index >= 0 && index < bookList.size()) {
            return bookList.get(index);
        }
        return null;
    }

    public int numberOfBooks() {
        return bookList.size();
    }

    public double totalPrice() {
        return bookList.stream()
                .mapToDouble(Book::getPrice)
                .sum();
    }

    public int totalPages() {
        return bookList.stream()
                .mapToInt(Book::getPages)
                .sum();
    }

    public List<Book> sortIncreasingByTitle() {
        List<Book> sortedList = new ArrayList<>(bookList);
        Collections.sort(sortedList, Comparator.comparing(Book::getTitle));
        return sortedList;
    }

    public List<Book> sortByPublisherAndPrice() {
        List<Book> sortedList = new ArrayList<>(bookList);
        Collections.sort(sortedList, Comparator
                .comparing(Book::getPublisher)
                .thenComparing(Book::getPrice, Comparator.reverseOrder()));
        return sortedList;
    }

    public List<Book> sortIncreasingPrice() {
        List<Book> sortedList = new ArrayList<>(bookList);
        Collections.sort(sortedList, Comparator.comparingDouble(Book::getPrice));
        return sortedList;
    }

    public List<Book> sortDecreasingPrice() {
        List<Book> sortedList = new ArrayList<>(bookList);
        Collections.sort(sortedList, Comparator.comparingDouble(Book::getPrice).reversed());
        return sortedList;
    }

    public List<Book> filterBooksOfGenre(String genre) {
        return bookList.stream()
                .filter(book -> book.getGenre().equalsIgnoreCase(genre))
                .collect(Collectors.toList());
    }

    public List<Book> filterBooksOfAuthor(String author) {
        return bookList.stream()
                .filter(book -> book.getAuthor().equalsIgnoreCase(author))
                .collect(Collectors.toList());
    }

    public List<Book> filterBooksOfPublisher(String publisher) {
        return bookList.stream()
                .filter(book -> book.getPublisher().equalsIgnoreCase(publisher))
                .collect(Collectors.toList());
    }

    public static String titleOfBooksToString(List<Book> bookList) {
        StringBuilder titleOfBooks = new StringBuilder("[\n");
        for (Book book : bookList) {
            titleOfBooks.append(book.getTitle()).append("\n");
        }
        return titleOfBooks.toString().trim() + "\n]";
    }

    public static void print(List<Book> bookList) {
        StringBuilder booksString = new StringBuilder("[\n");
        for (Book book : bookList) {
            booksString.append(book.toString()).append("\n");
        }
        System.out.print(booksString.toString().trim() + "\n]");
    }
}