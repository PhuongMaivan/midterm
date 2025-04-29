package hus.oop.gkk1_2425.statistics;

public class ArrayDataSet extends AbstractDataSet {
    private static final int DEFAULT_CAPACITY = 8;
    private double[] data;
    private int size;

    /**
     * Hàm dựng để khởi tạo dữ liệu.
     */
    public ArrayDataSet() {
        data = new double[DEFAULT_CAPACITY];
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public double getAt(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        return data[index];
    }

    @Override
    public double[] getAll(int from, int to) {
        if (from < 0 || to >= size || from > to) {
            throw new IndexOutOfBoundsException("Invalid range");
        }
        double[] result = new double[to - from + 1];
        System.arraycopy(data, from, result, 0, result.length);
        return result;
    }

    @Override
    public void append(double value) {
        if (size == data.length) {
            allocateMore();
        }
        data[size++] = value;
    }

    @Override
    public void insert(int index, double value) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        if (size == data.length) {
            allocateMore();
        }
        System.arraycopy(data, index, data, index + 1, size - index);
        data[index] = value;
        size++;
    }

    @Override
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        System.arraycopy(data, index + 1, data, index, size - index - 1);
        size--;
    }

    @Override
    public void remove(double value) {
        for (int i = 0; i < size; i++) {
            if (data[i] == value) {
                remove(i);
                i--; // To account for the removed element
            }
        }
    }

    private void allocateMore() {
        double[] newData = new double[data.length * 2];
        System.arraycopy(data, 0, newData, 0, size);
        data = newData;
    }
}