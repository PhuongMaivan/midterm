package hus.oop.datastructure;

public class MyLinkedListQueue implements MyQueue {
    private Node head;
    private Node tail;

    @Override
    public void enqueue(int element) {
        Node newNode = new Node(element);
        if (isEmpty()) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;
    }

    @Override
    public int dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        int element = head.data;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        return element;
    }

    @Override
    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return head.data;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }
}