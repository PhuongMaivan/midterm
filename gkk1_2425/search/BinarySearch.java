package hus.oop.gkk1_2425.search;

public class BinarySearch implements Search {
    private Sorter sorter;

    public BinarySearch() {
        this.sorter = new BubbleSort(); // Mặc định sử dụng BubbleSort
    }

    public void setSorter(Sorter sorter) {
        this.sorter = sorter;
    }

    @Override
    public int search(double[] data, double value) {
        sort(data); // Sắp xếp mảng trước khi tìm kiếm
        return binarySearch(data, value);
    }

    private int binarySearch(double[] data, double value) {
        int left = 0;
        int right = data.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (data[mid] == value) {
                return mid;
            } else if (data[mid] < value) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    private void sort(double[] data) {
        sorter.sort(data, true); // Sắp xếp tăng dần để tìm kiếm nhị phân
    }
}