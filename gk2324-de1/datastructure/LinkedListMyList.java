package hus.oop.datastructure;

public class LinkedListMyList extends AbstractMyList {
    private Node start;
    private Node end;
    private int size;

    /**
     * Hàm dựng khởi tạo list để chứa dữ liệu.
     */
    public LinkedListMyList() {
        this.start = null;
    }

    @Override
    public int size() {
        /* TODO */
        return size;
    }

    /**
     * Lấy giá trị của phần tử ở vị trí index.
     * @param index
     * @return
     */
    @Override
    public int get(int index) {
        /* TODO */
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node current = start;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    /**
     * Sửa dữ liệu ở vị trí index thành data.
     * @param data
     * @param index
     */
    @Override
    public void set(int data, int index) {
        /* TODO */
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node current = start;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        current.data = data;
    }

    /**
     * Thêm phần tử dữ liệu vào đầu tập dữ liệu.
     * @param value giá trị của phần tử dữ liệu được thêm vào.
     */
    @Override
    public void insertAtStart(int value) {
        /* TODO */
        if (start == null) {
            start = new Node(value);
            size++;
            end = start;
            return;
        }
        Node newHead = new Node(value);
        newHead.next = start;
        start = newHead;
        size++;
    }

    /**
     * Thêm phần tử dữ liệu vào cuối tập dữ liệu.
     * @param value giá trị của phần tử dữ liệu được thêm vào.
     */
    @Override
    public void insertAtEnd(int value) {
        /* TODO */
        Node newEnd = new Node(value);
        end.next = newEnd;
        end = newEnd;
        size++;
    }

    /**
     * Thêm phần tử dữ liệu vào vị trí index của tập dữ liệu.
     * Chỉ thêm được nếu index nằm trong đoạn [0 - size()].
     * @param value
     * @param index
     */
    @Override
    public void insertAtPos(int value, int index) {
        /* TODO */
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node current = start;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        Node newNode = new Node(value);
        newNode.next = current.next;
        current.next = newNode;
        size++;
    }

    /**
     * Xóa phần tử dữ liệu tại vị trí index.
     * Chỉ xóa được nếu index nằm trong đoạn [0 - (size() - 1)]
     * @param index
     */
    @Override
    public void remove(int index) {
        /* TODO */
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            start = start.next;
            size--;
            return;
        }
        Node current = start;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        current.next = current.next.next;
        size--;
    }

    /**
     * Phương thức lấy Node ở vị trí index.
     * @param index
     * @return
     */
    private Node getNodeByIndex(int index) {
        /* TODO */
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node current = start;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    /**
     * Lấy ra dữ liệu được lưu theo cấu trúc dữ liệu kiểu mảng.
     * @return
     */
    @Override
    public int[] toArray() {
        /* TODO */
        int[] array = new int[size];
        Node current = start;
        for (int i = 0; i < array.length; i++) {
            array[i] = current.data;
            current = current.next;
        }
        return array;
    }
}
