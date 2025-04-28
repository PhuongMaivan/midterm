package hus.oop.datastructure;

/**
 * Stack sử dụng cấu trúc dữ liệu linked list.
 */
public class MyLinkedListStack implements MyStack {
    private Node top;

    @Override
    public void push(int value) {
        Node newNode = new Node(value);
        newNode.next = top;
        top = newNode;
    }

    @Override
    public int pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        int value = top.data;
        top = top.next;
        return value;
    }

    @Override
    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return top.data;
    }

    @Override
    public boolean isEmpty() {
        return top == null;
    }
}