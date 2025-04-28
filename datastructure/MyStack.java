package hus.oop.datastructure;

public interface MyStack {
    /**
     * Thêm phần tử vào đầu stack.
     * @param element phần tử được thêm vào đầu stack
     */
    void push(int element);

    /**
     * Xóa phần tử ở đỉnh stack.
     * @return phần tử ở đỉnh stack
     */
    int pop();

    /**
     * Lấy giá trị ở đỉnh stack mà không xóa đi phần tử đó.
     * @return phần tử ở đỉnh stack
     */
    int peek();

    /**
     * Trả lại true nếu stack rỗng.
     * Trả lại false nếu stack không rỗng.
     */
    boolean isEmpty();
}