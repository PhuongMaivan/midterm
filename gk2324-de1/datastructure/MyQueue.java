package hus.oop.datastructure;

public class MyQueue {
    private MyList queueData;

    public MyQueue() {
        this.queueData = new LinkedListMyList();
    }

    /**
     * Thêm giá trị vào cuối của queue.
     * @param value
     */
    public void add(int value) {
        /* TODO */
        if (this.queueData.size() == 0) {
            queueData.insertAtStart(value);
            return;
        }
        queueData.insertAtEnd(value);
    }

    /**
     * Xóa và trả lại giá trị ở đầu của queue.
     * @return
     */
    public int remove() {
        /* TODO */
        queueData.remove(0);
        return queueData.get(0);
    }

    /**
     * Kiểm tra xem queue có rỗng hay không.
     * @return true nếu queue không chứa giá trị nào, false nếu queue đã chứa giá trị.
     */
    public boolean isEmpty() {
        /* TODO */
        return queueData.size() == 0;
    }

    /**
     * Trả lại giá trị ở đầu của queue mà không xóa phần tử.
     * @return giá trị ở vị trí đầu của queue.
     */
    public int peek() {
        /* TODO */
        return queueData.get(0);
    }

    /**
     * Lấy kích thước của queue.
     * @return
     */
    public int size() {
        /* TODO */
        return queueData.size();
    }

    @Override
    public String toString() {
        return queueData.toString();
    }
}
