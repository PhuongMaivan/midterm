package hus.oop.gkk1_2425.datastructure;

import java.util.Random;

public class App {
    public static void main(String[] args) {
        testStack();
        testQueue();
    }

    public static void testStack() {
        System.out.println("Testing Stack:");
        Random random = new Random();
        int n = 20 + random.nextInt(11); // Random number between 20-30
        MyStack stack = new MyStack();

        System.out.println("Adding " + n + " random numbers to stack:");
        for (int i = 0; i < n; i++) {
            int num = random.nextInt(100);
            stack.push(num);
            System.out.print(num + " ");
        }
        System.out.println("\nStack size: " + stack.size());

        System.out.println("\nRemoving elements from stack:");
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
            System.out.println("Remaining size: " + stack.size());
        }
    }

    public static void testQueue() {
        System.out.println("\nTesting Queue:");
        Random random = new Random();
        int n = 20 + random.nextInt(11); // Random number between 20-30
        MyQueue queue = new MyQueue();

        System.out.println("Adding " + n + " random numbers to queue:");
        for (int i = 0; i < n; i++) {
            int num = random.nextInt(100);
            queue.add(num);
            System.out.print(num + " ");
        }
        System.out.println("\nQueue size: " + queue.size());

        System.out.println("\nRemoving elements from queue:");
        while (!queue.isEmpty()) {
            System.out.print(queue.remove() + " ");
            System.out.println("Remaining size: " + queue.size());
        }
    }
}