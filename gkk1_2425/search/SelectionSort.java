package hus.oop.gkk1_2425.search;

public class SelectionSort implements Sorter {
    @Override
    public void sort(double[] data, boolean order) {
        if (order) {
            sortAscending(data);
        } else {
            sortDescending(data);
        }
    }

    private void sortAscending(double[] data) {
        int n = data.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (data[j] < data[minIdx]) {
                    minIdx = j;
                }
            }
            // Swap phần tử nhỏ nhất với phần tử đầu tiên chưa sắp xếp
            double temp = data[minIdx];
            data[minIdx] = data[i];
            data[i] = temp;
        }
    }

    private void sortDescending(double[] data) {
        int n = data.length;
        for (int i = 0; i < n - 1; i++) {
            int maxIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (data[j] > data[maxIdx]) {
                    maxIdx = j;
                }
            }
            // Swap phần tử lớn nhất với phần tử đầu tiên chưa sắp xếp
            double temp = data[maxIdx];
            data[maxIdx] = data[i];
            data[i] = temp;
        }
    }
}