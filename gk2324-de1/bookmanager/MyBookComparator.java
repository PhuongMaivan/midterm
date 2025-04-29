package hus.oop.bookmanager;

import java.util.Comparator;

public interface MyBookComparator extends Comparator<Book> {
    int compare(Book left, Book right);
}
