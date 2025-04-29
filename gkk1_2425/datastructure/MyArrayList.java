package hus.oop.gkk1_2425.datastructure;

public class MyArrayList extends AbstractMyList {
    private static final int DEFAULT_CAPACITY = 8;
    private int[] data;
    private int size;

    public MyArrayList() {
        data = new int[DEFAULT_CAPACITY];
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int get(int index) {
        checkBoundaries(index, size - 1);
        return data[index];
    }

    @Override
    public void set(int data, int index) {
        checkBoundaries(index, size - 1);
        this.data[index] = data;
    }

    @Override
    public void insertAtStart(int value) {
        insertAtPosition(value, 0);
    }

    @Override
    public void insertAtEnd(int value) {
        if (size == data.length) {
            allocateMore();
        }
        data[size++] = value;
    }

    @Override
    public void insertAtPosition(int value, int index) {
        if (!checkBoundaries(index, size)) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        if (size == data.length) {
            allocateMore();
        }

        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = value;
        size++;
    }

    @Override
    public void remove(int index) {
        checkBoundaries(index, size - 1);
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;
    }

    private void allocateMore() {
        int[] newData = new int[data.length * 2];
        System.arraycopy(data, 0, newData, 0, data.length);
        data = newData;
    }

    @Override
    public int[] toArray() {
        int[] result = new int[size];
        System.arraycopy(data, 0, result, 0, size);
        return result;
    }
}