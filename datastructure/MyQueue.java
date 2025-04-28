package hus.oop.datastructure;

public interface MyQueue {
    /**
     * Thêm một phần tử vào cuối queue.
     *
     * @param element phần tử được thêm vào cuối queue
     */
    void enqueue(int element);

    /**
     * Xóa phần tử ở đầu queue.
     *
     * @return phần tử ở đầu queue
     */
    int dequeue();

    /**
     * Trả lại phần tử ở đầu queue nhưng không xóa phần tử đó.
     *
     * @return phần tử ở đầu queue
     */
    int peek();

    /**
     * Kiểm tra xem queue có rỗng hay không.
     */
    boolean isEmpty();
}