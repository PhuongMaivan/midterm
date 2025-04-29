package hus.oop.gkk1_2425.search;

public interface Search {
    /**
     * Tìm kiếm giá trị value trong mảng data.
     * @param data: mảng các giá trị.
     * @param value: giá trị cần tìm kiếm.
     * @return chỉ số của value trong mảng, -1 nếu không tìm thấy.
     */
    int search(double[] data, double value);
}
