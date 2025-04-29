package hus.oop.bookmanager;

public interface MyBookComparable extends Comparable<Book> {
    int compareTo(Book another);
}
