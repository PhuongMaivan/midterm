package hus.oop.datastructure;

public class ArrayMyList extends AbstractMyList {
    private static final int DEFAULT_CAPACITY = 16;
    private int[] data;
    private int size;

    /**
     * Hàm dựng để khởi tạo dữ liệu.
     */
    public ArrayMyList() {
        /* TODO */
        this.data = new int[DEFAULT_CAPACITY];
        this.size = 0;
    }

    /**
     * Lấy kích thước của tập dữ liệu.
     * @return
     */
    @Override
    public int size() {
        /* TODO */
        return this.size;
    }

    /**
     * Lấy giá trị của phần tử ở vị trí index.
     * @param index
     * @return
     */
    @Override
    public int get(int index) {
        /* TODO */
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException();
        }
        return this.data[index];
    }

    /**
     * Sửa dữ liệu ở vị trí index thành data.
     * @param data
     * @param index
     */
    @Override
    public void set(int data, int index) {
        /* TODO */
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException();
        }
        this.data[index] = data;
    }

    /**
     * Thêm phần tử dữ liệu vào đầu mảng dữ liệu.
     * Nếu mảng không còn chỗ, mở rộng mảng để có thể chứa thêm dữ liệu.
     * @param value là giá trị của phần tử dữ liệu được thêm vào.
     */
    @Override
    public void insertAtStart(int value) {
        /* TODO */
        if (this.size == this.data.length) {
           allocateMore();
        }
        System.arraycopy(this.data, 0, this.data, 1, this.size);
        this.data[0] = value;
        this.size++;
    }

    /**
     * Thêm phần tử dữ liệu vào cuối mảng dữ liệu.
     * Nếu mảng không còn chỗ, mở rộng mảng để có thể chứa thêm dữ liệu.
     * @param value là giá trị của phần tử dữ liệu được thêm vào.
     */
    @Override
    public void insertAtEnd(int value) {
        /* TODO */
        if (this.size == this.data.length) {
            allocateMore();
        }
        data[size] = value;
        size++;
    }

    /**
     * Thêm phần tử dữ liệu vào vị trí index của mảng dữ liệu.
     * Nếu mảng không còn chỗ, mở rộng mảng để có thể chứa thêm dữ liệu.
     * @param value
     * @param index
     */
    @Override
    public void insertAtPos(int value, int index) {
        /* TODO */
        if (this.size == this.data.length) {
            allocateMore();
        }
        if (index < 0 || index > this.size) {
            throw new IndexOutOfBoundsException();
        }
        size++;
        for (int i = size; i > index; i--) {
            this.data[i] = data[i - 1];
        }
        this.data[index] = value;
    }

    /**
     * Xóa phần tử dữ liệu tại vị trí index.
     * Chỉ xóa được nếu index nằm trong đoạn [0 - (size - 1)]
     * @param index
     */
    @Override
    public void remove(int index) {
        /* TODO */
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException();
        }
        for (int i = index; i < this.size - 1; i++) {
            this.data[i] = data[i + 1];
        }
        this.size--;
    }

    /**
     * Mở rộng gấp đôi kích thước mảng nếu hết chỗ để chứa dữ liệu.
     */
    private void allocateMore() {
        /* TODO */
        int[] newData = new int[this.data.length * 2];
        System.arraycopy(this.data, 0, newData, 0, this.size);
        this.data = newData;
    }

    /**
     * Lấy ra dữ liệu được lưu theo cấu trúc dữ liệu kiểu mảng.
     * @return
     */
    @Override
    public int[] toArray() {
        /* TODO */
        int[] copy = new int[size];
        System.arraycopy(data, 0, copy, 0, size);
        return copy;
    }
}
