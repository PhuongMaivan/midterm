package hus.oop.datastructure;

import java.util.concurrent.ThreadLocalRandom;

public class App {
    public static void main(String[] args) {
        /*
        Yêu cầu:

        - Hoàn thiện code chương trình theo mẫu đã cho.

        - Sinh ra một số tự nhiên ngẫu nhiên nằm trong đoạn [15 - 30], gọi là n.
        - Sinh ra n số nguyên ngẫu nhiên, cho vào stack.
            + In ra các phần tử trong stack.
            + Lần lượt xóa các phần tử trong stack. Sau mỗi lần xóa, in ra các phần tử còn lại trong stack.

        - Sinh ra n số nguyên ngẫu nhiên, cho vào queue.
            + In ra các phần tử trong queue.
            + Lần lượt xóa các phần tử trong queue. Sau mỗi lần xóa, in ra các phần tử còn lại trong queue.
        */
        testStack();
        System.out.println();
        testQueue();
    }

    public static void testStack() {
        /* TODO */
        int n = 15 + (int) (Math.random() * (15 + 1));
        MyStack myStack = new MyStack();
        for (int i = 0; i < n; i++) {
            myStack.push((int) (Math.random() * (100 + 1)));
        }
        System.out.println(myStack.toString());
        for (int i = 0; i < n; i++) {
            myStack.pop();
            System.out.println(myStack);
        }
    }

    public static void testQueue() {
        /* TODO */
        int n = 15 + (int) (Math.random() * (15 + 1));
        MyQueue myQueue = new MyQueue();
        for (int i = 0; i < n; i++) {
            myQueue.add((int) (Math.random() * (100 + 1)));
        }
        System.out.println(myQueue.toString());
        for (int i = 0; i < n - 1; i++) {
            myQueue.remove();
            System.out.println(myQueue);
        }
    }
}
