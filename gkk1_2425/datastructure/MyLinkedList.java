package hus.oop.gkk1_2425.datastructure;

public class MyLinkedList extends AbstractMyList {
    private Node head;
    private int size;

    public MyLinkedList() {
        head = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int get(int index) {
        return getNodeByIndex(index).data;
    }

    @Override
    public void set(int data, int index) {
        getNodeByIndex(index).data = data;
    }

    @Override
    public void insertAtStart(int value) {
        Node newNode = new Node(value);
        newNode.next = head;
        head = newNode;
        size++;
    }

    @Override
    public void insertAtEnd(int value) {
        if (head == null) {
            insertAtStart(value);
        } else {
            Node lastNode = getNodeByIndex(size - 1);
            lastNode.next = new Node(value);
            size++;
        }
    }

    @Override
    public void insertAtPosition(int value, int index) {
        if (index == 0) {
            insertAtStart(value);
        } else if (index == size) {
            insertAtEnd(value);
        } else {
            Node prevNode = getNodeByIndex(index - 1);
            Node newNode = new Node(value);
            newNode.next = prevNode.next;
            prevNode.next = newNode;
            size++;
        }
    }

    @Override
    public void remove(int index) {
        if (index == 0) {
            head = head.next;
        } else {
            Node prevNode = getNodeByIndex(index - 1);
            prevNode.next = prevNode.next.next;
        }
        size--;
    }

    private Node getNodeByIndex(int index) {
        checkBoundaries(index, size - 1);
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    @Override
    public int[] toArray() {
        int[] result = new int[size];
        Node current = head;
        for (int i = 0; i < size; i++) {
            result[i] = current.data;
            current = current.next;
        }
        return result;
    }
}