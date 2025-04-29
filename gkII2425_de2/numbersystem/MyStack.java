package hus.oop.gkII2425_de2.numbersystem;

public class MyStack {
    private MyList stack;

    public MyStack() {
        this.stack = new MyArrayList();
    }

    /**
     * Thêm dữ liệu vào đầu stack.
     * @param value
     */
    public void push(int value) {
        stack.insertAtStart(value);
    }

    /**
     * Xóa và trả lại giá trị ở vị trí đầu stack.
     * @return
     */
    public int pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        int value = stack.get(0);
        stack.remove(0);
        return value;
    }

    /**
     * Kiểm tra xem stack có rỗng không.
     * @return true nếu stack rỗng, false nếu stack không rỗng.
     */
    public boolean isEmpty() {
        return stack.size() == 0;
    }

    /**
     * Trả lại giá trị ở đầu stack mà không xóa phần tử.
     * @return giá trị ở vị trí đầu stack.
     */
    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return stack.get(0);
    }

    /**
     * Lấy kích thước của stack.
     * @return
     */
    public int size() {
        return stack.size();
    }
}