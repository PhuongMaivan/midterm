package hus.oop.gk2023_2024.bookmanager;

public class TitleThenPriceComparator implements MyBookComparator {
    private boolean titleAsc;

    public TitleThenPriceComparator(boolean titleAsc) {
        this.titleAsc = titleAsc;
    }

    @Override
    public int compare(Book left, Book right) {
        int cmp = left.getTitle().compareToIgnoreCase(right.getTitle());
        if (!titleAsc) cmp *= -1;
        if (cmp == 0) {
            return Double.compare(right.getPrice(), left.getPrice());
        }
        return cmp;
    }
}