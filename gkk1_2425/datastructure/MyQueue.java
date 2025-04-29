package hus.oop.gkk1_2425.datastructure;

public class MyQueue {
    private MyList queueData;

    public MyQueue() {
        this.queueData = new MyArrayList();
    }

    public void add(int value) {
        queueData.insertAtEnd(value);
    }

    public int remove() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        int value = queueData.get(0);
        queueData.remove(0);
        return value;
    }

    public boolean isEmpty() {
        return queueData.size() == 0;
    }

    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return queueData.get(0);
    }

    public int size() {
        return queueData.size();
    }
}
