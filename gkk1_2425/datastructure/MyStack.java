package hus.oop.gkk1_2425.datastructure;

public class MyStack {
    private MyList stackData;

    public MyStack() {
        this.stackData = new MyLinkedList();
    }

    public void push(int value) {
        stackData.insertAtStart(value);
    }

    public int pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        int value = stackData.get(0);
        stackData.remove(0);
        return value;
    }

    public boolean isEmpty() {
        return stackData.size() == 0;
    }

    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return stackData.get(0);
    }

    public int size() {
        return stackData.size();
    }
}