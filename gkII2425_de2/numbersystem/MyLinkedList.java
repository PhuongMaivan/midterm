package hus.oop.gkII2425_de2.numbersystem;

public class MyLinkedList extends MyAbstractList {
    private Node start;
    private Node end;
    private int size;

    /**
     * Hàm dựng khởi tạo list để chứa dữ liệu.
     */
    public MyLinkedList() {
        this.start = null;
        this.end = null;
        this.size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    /**
     * Lấy giá trị của phần tử ở vị trí index.
     * @param index
     * @return
     */
    @Override
    public int get(int index) {
        if (!checkBoundaries(index, size - 1)) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds for length " + size);
        }

        return getNodeByIndex(index).data;
    }

    /**
     * Sửa dữ liệu ở vị trí index thành data.
     * @param data
     * @param index
     */
    @Override
    public void set(int data, int index) {
        if (!checkBoundaries(index, size - 1)) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds for length " + size);
        }

        Node node = getNodeByIndex(index);
        node.data = data;
    }

    /**
     * Thêm phần tử dữ liệu vào đầu tập dữ liệu.
     * @param value giá trị của phần tử dữ liệu được thêm vào.
     */
    @Override
    public void insertAtStart(int value) {
        Node newNode = new Node(value);

        if (start == null) {
            // Danh sách rỗng
            start = newNode;
            end = newNode;
        } else {
            // Danh sách có ít nhất một phần tử
            newNode.next = start;
            start = newNode;
        }

        size++;
    }

    /**
     * Thêm phần tử dữ liệu vào cuối tập dữ liệu.
     * @param value giá trị của phần tử dữ liệu được thêm vào.
     */
    @Override
    public void insertAtEnd(int value) {
        Node newNode = new Node(value);

        if (end == null) {
            // Danh sách rỗng
            start = newNode;
            end = newNode;
        } else {
            // Danh sách có ít nhất một phần tử
            end.next = newNode;
            end = newNode;
        }

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
        if (!checkBoundaries(index, size)) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds for length " + size);
        }

        if (index == 0) {
            insertAtStart(value);
        } else if (index == size) {
            insertAtEnd(value);
        } else {
            Node newNode = new Node(value);
            Node prevNode = getNodeByIndex(index - 1);

            newNode.next = prevNode.next;
            prevNode.next = newNode;

            size++;
        }
    }

    /**
     * Xóa phần tử dữ liệu tại vị trí index.
     * Chỉ xóa được nếu index nằm trong đoạn [0 - (size() - 1)]
     * @param index
     */
    @Override
    public void remove(int index) {
        if (!checkBoundaries(index, size - 1)) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds for length " + size);
        }

        if (index == 0) {
            // Xóa phần tử đầu tiên
            start = start.next;
            if (start == null) {
                end = null;
            }
        } else {
            // Xóa phần tử ở giữa hoặc cuối
            Node prevNode = getNodeByIndex(index - 1);
            Node nodeToRemove = prevNode.next;

            prevNode.next = nodeToRemove.next;

            if (nodeToRemove == end) {
                end = prevNode;
            }
        }

        size--;
    }

    /**
     * Phương thức lấy Node ở vị trí index.
     * @param index
     * @return
     */
    private Node getNodeByIndex(int index) {
        if (!checkBoundaries(index, size - 1)) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds for length " + size);
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
        int[] result = new int[size];

        Node current = start;
        for (int i = 0; i < size; i++) {
            result[i] = current.data;
            current = current.next;
        }

        return result;
    }
}