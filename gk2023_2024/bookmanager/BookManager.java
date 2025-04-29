package hus.oop.gk2023_2024.bookmanager;

import java.util.*;
import java.util.stream.Collectors;

public class BookManager {
    private List<Book> bookList;

    public BookManager() {
        bookList = new ArrayList<>();
    }

    public List<Book> getBookList() {
        return bookList;
    }

    private boolean checkBoundaries(int index, int limit) {
        return index >= 0 && index < limit;
    }

    public void insertAtEnd(Book book) {
        bookList.add(book);
    }

    public void insertAPos(Book book, int index) {
        if (checkBoundaries(index, bookList.size())) {
            bookList.add(index, book);
        }
    }

    public void remove(int index) {
        if (checkBoundaries(index, bookList.size())) {
            bookList.remove(index);
        }
    }

    public void remove(Book book) {
        bookList.remove(book);
    }

    public Book bookAt(int index) {
        if (checkBoundaries(index, bookList.size())) {
            return bookList.get(index);
        }
        return null;
    }

    public List<Book> sortIncreasingByTitle() {
        return bookList.stream()
                .sorted(Book::compareTo)
                .collect(Collectors.toList());
    }

    public List<Book> sortIncreasingTitleAndPrice() {
        return bookList.stream()
                .sorted(new TitleThenPriceComparator(true)::compare)
                .collect(Collectors.toList());
    }

    public List<Book> sortDecreasingTitleAndPrice() {
        return bookList.stream()
                .sorted(new TitleThenPriceComparator(false)::compare)
                .collect(Collectors.toList());
    }

    public List<Book> sortIncreasingPrice() {
        return bookList.stream()
                .sorted(Comparator.comparingDouble(Book::getPrice))
                .collect(Collectors.toList());
    }

    public List<Book> sortDecreasingPrice() {
        return bookList.stream()
                .sorted(Comparator.comparingDouble(Book::getPrice).reversed())
                .collect(Collectors.toList());
    }

    public List<Book> sortIncreasingPages() {
        return bookList.stream()
                .sorted(Comparator.comparingInt(Book::getPages))
                .collect(Collectors.toList());
    }

    public List<Book> sortDecreasingPages() {
        return bookList.stream()
                .sorted(Comparator.comparingInt(Book::getPages).reversed())
                .collect(Collectors.toList());
    }

    public List<Book> filterHighestPrice(int howMany) {
        return bookList.stream()
                .sorted(Comparator.comparingDouble(Book::getPrice).reversed())
                .limit(howMany)
                .collect(Collectors.toList());
    }

    public List<Book> filterBooksPriceHigherThan(double lowerBound) {
        return bookList.stream()
                .filter(book -> book.getPrice() > lowerBound)
                .collect(Collectors.toList());
    }

    public List<Book> filterBookLowestPages(int howMany) {
        return bookList.stream()
                .sorted(Comparator.comparingInt(Book::getPages))
                .limit(howMany)
                .collect(Collectors.toList());
    }

    public List<Book> filterBooksPagesLowerThan(double upperBound) {
        return bookList.stream()
                .filter(book -> book.getPages() < upperBound)
                .collect(Collectors.toList());
    }

    public List<Book> filterBooksOfPublisher(String publisher) {
        return bookList.stream()
                .filter(book -> book.getPublisher().equalsIgnoreCase(publisher))
                .collect(Collectors.toList());
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

    public static String titleOfBooksToString(List<Book> bookList) {
        return bookList.stream()
                .map(Book::getTitle)
                .collect(Collectors.joining("\n", "[\n", "\n]"));
    }

    public static void print(List<Book> bookList) {
        bookList.forEach(System.out::println);
    }
}