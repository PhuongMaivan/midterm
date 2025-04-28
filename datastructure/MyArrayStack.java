package hus.oop.datastructure;

/**
 * Stack sử dụng cấu trúc dữ liệu mảng.
 */
public class MyArrayStack implements MyStack {
    public static final int MAX_SIZE = Integer.MAX_VALUE - 8;
    private static final int DEFAULT_INITIAL_CAPACITY = 8;
    private int[] elements;
    private int numberOfElements;

    public MyArrayStack() {
        this(DEFAULT_INITIAL_CAPACITY);
    }

    public MyArrayStack(int initialCapacity) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("Initial capacity cannot be negative");
        }
        elements = new int[initialCapacity];
        numberOfElements = 0;
    }

    @Override
    public void push(int value) {
        if (numberOfElements == elements.length) {
            grow();
        }
        elements[numberOfElements++] = value;
    }

    /*
     * Tăng kích thước stack lên gấp đôi.
     */
    private void grow() {
        int newCapacity = elements.length * 2;
        // Kiểm tra tràn số
        if (newCapacity < 0 || newCapacity > MAX_SIZE) {
            newCapacity = MAX_SIZE;
        }

        int[] newElements = new int[newCapacity];
        System.arraycopy(elements, 0, newElements, 0, numberOfElements);
        elements = newElements;
    }

    @Override
    public int pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return elements[--numberOfElements];
    }

    @Override
    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return elements[numberOfElements - 1];
    }

    @Override
    public boolean isEmpty() {
        return numberOfElements == 0;
    }
}