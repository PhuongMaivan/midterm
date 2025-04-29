package hus.oop.bookmanager;

import java.util.*;

public class BookManager {
    private List<Book> bookList;

    public BookManager() {
        bookList = new LinkedList<>();
    }

    public List<Book> getBookList() {
        /* TODO */
        return bookList;
    }

    /**
     * Phương thức kiểm tra xem chỉ số index có nằm trong đoạn [0 - limit] hay không.
     * @param index
     * @param limit
     * @return
     */
    private boolean checkBoundaries(int index, int limit) {
        /* TODO */
        return index >= 0 && index <= limit;
    }

    /**
     * Thêm book vào cuối danh sách.
     * @param book
     */
    public void append(Book book) {
        /* TODO */
        bookList.add(book);
    }

    /**
     * Thêm book vào danh sách ở vị trí index.
     * @param book
     * @param index
     */
    public void add(Book book, int index) {
        /* TODO */
        if (checkBoundaries(index, bookList.size() - 1)) {
            bookList.add(index, book);
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    /**
     * Xóa book ở vị trí index.
     * @param index
     */
    public void remove(int index) {
        /* TODO */
        if (checkBoundaries(index, bookList.size() - 1)) {
            bookList.remove(index);
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    /**
     * Bỏ book như tham số truyền vào.
     * @param book
     */
    public void remove(Book book) {
        /* TODO */
        bookList.remove(book);
    }

    /**
     * Lấy ra book ở vị trí index
     * @param index
     * @return
     */
    public Book bookAt(int index) {
        /* TODO */
        if (checkBoundaries(index, bookList.size() - 1)) {
            return bookList.get(index);
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    /**
     * Sắp xếp danh sách book theo thứ tự tăng dần theo genre và sau đó đến title.
     * @return
     */
    public List<Book> sortIncreasingByGenreAndTitle() {
        /* TODO */
        List<Book> copiedList = new ArrayList<>(bookList);
        Collections.sort(copiedList);
        return copiedList;
    }

    /**
     * Sắp xếp sách theo tiêu chí, đầu tiên theo genre tăng dần, nếu genre như nhau thì theo thứ tự giá giảm dần.
     * Sử dụng giao diện MyBookComparator để thực hiện tiêu chí sắp xếp.
     * @return
     */
    public List<Book> sortIncreasingGenreAndPrice() {
        /* TODO */
        List<Book> copiedList = new ArrayList<>(bookList);

        MyBookComparator sortingRule = (Book left, Book right) -> {
            int diffGenre = left.getGenre().compareTo(right.getGenre());
            if (diffGenre != 0) {
                return diffGenre;
            }
            return right.getTitle().compareTo(left.getTitle());
        };

        Collections.sort(copiedList, sortingRule);

        return copiedList;
    }

    /**
     * Sắp xếp sách theo tiêu chí, đầu tiên theo genre giảm dần, nếu genre như nhau thì theo thứ tự giá giảm dần.
     * Sử dụng giao diện MyBookComparator để thực hiện tiêu chí sắp xếp.
     * @return
     */
    public List<Book> sortDecreasingGenreAndPrice() {
        /* TODO */
        List<Book> copiedList = new ArrayList<>(bookList);

        MyBookComparator sortingRule = (Book left, Book right) -> {
            int diffGenre = left.getGenre().compareTo(right.getGenre());
            if (diffGenre != 0) {
                return diffGenre;
            }
            return right.getTitle().compareTo(left.getTitle());
        };

        Collections.sort(copiedList, Collections.reverseOrder(sortingRule));

        return copiedList;
    }

    /**
     * Sắp xếp sách theo giá tăng dần.
     * @return
     */
    public List<Book> sortIncreasingPrice() {
        /* TODO */
        List<Book> copiedList = new ArrayList<>(bookList);

        MyBookComparator sortingRule = (Book left, Book right) -> {
            if (left.getPrice() > right.getPrice()) {
                return 1;
            } else if (left.getPrice() == right.getPrice()) {
                return 0;
            }
            return -1;
        };

        Collections.sort(copiedList, sortingRule);

        return copiedList;
    }

    /**
     * Sắp xếp sách theo giá giảm dần.
     * @return
     */
    public List<Book> sortDecreasingPrice() {
        /* TODO */
        List<Book> copiedList = new ArrayList<>(bookList);

        MyBookComparator sortingRule = (Book left, Book right) -> {
            if (left.getPrice() > right.getPrice()) {
                return 1;
            } else if (left.getPrice() == right.getPrice()) {
                return 0;
            }
            return -1;
        };

        Collections.sort(copiedList, Collections.reverseOrder(sortingRule));

        return copiedList;
    }

    /**
     * Sắp xếp sách theo số trang tăng dần.
     * @return
     */
    public List<Book> sortIncreasingPages() {
        /* TODO */
        List<Book> copiedList = new ArrayList<>(bookList);

        MyBookComparator sortingRule = (Book left, Book right) -> {
            if (left.getPages() > right.getPages()) {
                return 1;
            } else if (left.getPages() == right.getPages()) {
                return 0;
            }
            return -1;
        };

        Collections.sort(copiedList, sortingRule);

        return copiedList;
    }

    /**
     * Sắp xếp sách theo số trang giảm dần.
     * @return
     */
    public List<Book> sortDecreasingPages() {
        /* TODO */
        List<Book> copiedList = new ArrayList<>(bookList);

        MyBookComparator sortingRule = (Book left, Book right) -> {
            if (left.getPrice() > right.getPrice()) {
                return 1;
            } else if (left.getPrice() == right.getPrice()) {
                return 0;
            }
            return -1;
        };

        Collections.sort(copiedList, Collections.reverseOrder(sortingRule));

        return copiedList;
    }

    /**
     * Lọc ra howMany sách có số trang lớn nhất.
     * @param howMany
     * @return
     */
    public List<Book> filterHighestPages(int howMany) {
        /* TODO */
        List<Book> sortedList = sortDecreasingPages();
        List<Book> highestPages = new ArrayList<>();

        Iterator<Book> iterator = sortedList.iterator();
        while (iterator.hasNext() && howMany > 0) {
            highestPages.add(iterator.next());
            howMany--;
        }

        return highestPages;
    }

    /**
     * Lọc ra những sách có số trang cao hơn lowerBound.
     * @param lowerBound
     * @return
     */
    public List<Book> filterBooksPagesHigherThan(double lowerBound) {
        /* TODO */
        List<Book> filteredBook = new ArrayList<>();

        for (Book book : bookList) {
            if (book.getPages() > lowerBound) {
                filteredBook.add(book);
            }
        }

        return filteredBook;
    }

    /**
     * Lọc ra howMany sách có số trang nhỏ nhất.
     * @param howMany
     * @return
     */
    public List<Book> filterBookLowestPages(int howMany) {
        /* TODO */
        List<Book> sortedList = sortIncreasingPages();
        List<Book> highestPages = new ArrayList<>();

        Iterator<Book> iterator = sortedList.iterator();
        while (iterator.hasNext() && howMany > 0) {
            highestPages.add(iterator.next());
            howMany--;
        }

        return highestPages;
    }

    /**
     * Lọc ra howMany sách có số trang nhỏ hơn upperBound.
     * @param upperBound
     * @return
     */
    public List<Book> filterBooksPagesLowerThan(double upperBound) {
        /* TODO */
        List<Book> filteredBook = new ArrayList<>();

        for (Book book : bookList) {
            if (book.getPages() < upperBound) {
                filteredBook.add(book);
            }
        }

        return filteredBook;
    }

    public List<Book> filterBooksLowestPrice(double howMany) {
        /* TODO */
        List<Book> sortedList = sortIncreasingPrice();
        List<Book> lowestPriceBooks = new ArrayList<>();

        Iterator<Book> iterator = sortedList.iterator();
        while (iterator.hasNext() && howMany > 0) {
            lowestPriceBooks.add(iterator.next());
            howMany--;
        }

        return lowestPriceBooks;
    }

    public List<Book> filterBooksHighestPrice(double howMany) {
        /* TODO */
        List<Book> sortedList = sortDecreasingPrice();
        List<Book> lowestPriceBooks = new ArrayList<>();

        Iterator<Book> iterator = sortedList.iterator();
        while (iterator.hasNext() && howMany > 0) {
            lowestPriceBooks.add(iterator.next());
            howMany--;
        }

        return lowestPriceBooks;
    }

    /**
     * Lọc ra những sách theo nhà xuất bản.
     * @param publisher
     * @return
     */
    public List<Book> filterBooksOfPublisher(String publisher) {
        /* TODO */
        List<Book> filteredBook = new ArrayList<>();

        for (Book book : bookList) {
            if (book.getPublisher().equals(publisher)) {
                filteredBook.add(book);
            }
        }

        return filteredBook;
    }

    /**
     * Lọc ra những sách theo thể loại.
     * @param genre
     * @return
     */
    public List<Book> filterBooksOfGenre(String genre) {
        /* TODO */
        List<Book> filteredBook = new ArrayList<>();

        for (Book book : bookList) {
            if (book.getGenre().equals(genre)) {
                filteredBook.add(book);
            }
        }

        return filteredBook;
    }

    /**
     * Lọc ra những sách theo tác giả.
     * @param author
     * @return
     */
    public List<Book> filterBooksOfAuthor(String author) {
        /* TODO */
        List<Book> filteredBook = new ArrayList<>();

        for (Book book : bookList) {
            if (book.getAuthor().equals(author)) {
                filteredBook.add(book);
            }
        }

        return filteredBook;
    }

    public static String titleOfBooksToString(List<Book> bookList) {
        StringBuilder titleOfBooks = new StringBuilder();
        titleOfBooks.append("[\n");
        for (Book book : bookList) {
            titleOfBooks.append(book.getTitle()).append("\n");
        }
        return titleOfBooks.toString().trim() + "\n]";
    }

    public static void print(List<Book> bookList) {
        StringBuilder booksString = new StringBuilder();
        booksString.append("[\n");
        for (Book book : bookList) {
            booksString.append(book.toString()).append("\n");
        }
        System.out.print(booksString.toString().trim() + "\n]");
    }
}
