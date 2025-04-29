package hus.oop.gkk1_2425.search;

public interface Sorter {

    /**
     * Phương thức sắp xếp mảng dữ liệu data.
     * Nếu order là true thì sắp xếp theo thứ tự tăng dần,
     * nếu order là false thì sắp xếp theo thứ tự giảm dần.
     * @param data
     * @param order
     */
    void sort(double[] data, boolean order);
}
