package hus.oop.datastructure;

import java.util.Random;

public class TestDataStructure {
    public static void main(String[] args) {
        System.out.println("===== Test Array Stack =====");
        testArrayStack();
        System.out.println("\n===== Test Linked List Stack =====");
        testLinkedListStack();
        System.out.println("\n===== Test Array Queue =====");
        testArrayQueue();
        System.out.println("\n===== Test Linked List Queue =====");
        testLinkedListQueue();
    }

    public static void testArrayStack() {
        Random random = new Random();
        int n = random.nextInt(11) + 20; // Số trong khoảng [20-30]
        System.out.println("Số phần tử n = " + n);

        MyArrayStack stack = new MyArrayStack();

        // Thêm n phần tử ngẫu nhiên vào stack
        System.out.print("Các phần tử được thêm vào stack: ");
        for (int i = 0; i < n; i++) {
            int value = random.nextInt(100); // Số ngẫu nhiên từ 0-99
            System.out.print(value + " ");
            stack.push(value);
        }
        System.out.println();

        // In ra các phần tử trong stack
        System.out.print("Các phần tử trong stack: ");
        MyArrayStack tempStack = new MyArrayStack();
        while (!stack.isEmpty()) {
            int value = stack.pop();
            System.out.print(value + " ");
            tempStack.push(value);
        }
        System.out.println();

        // Khôi phục stack
        while (!tempStack.isEmpty()) {
            stack.push(tempStack.pop());
        }

        // Lần lượt xóa các phần tử trong stack
        System.out.println("Lần lượt xóa các phần tử trong stack:");
        int count = 1;
        while (!stack.isEmpty()) {
            int popped = stack.pop();
            System.out.println("Pop thứ " + count + ": " + popped);

            // In ra các phần tử còn lại
            System.out.print("Các phần tử còn lại: ");
            tempStack = new MyArrayStack();
            if (stack.isEmpty()) {
                System.out.print("(Stack rỗng)");
            } else {
                while (!stack.isEmpty()) {
                    int value = stack.pop();
                    System.out.print(value + " ");
                    tempStack.push(value);
                }
            }
            System.out.println();

            // Khôi phục stack
            while (!tempStack.isEmpty()) {
                stack.push(tempStack.pop());
            }

            count++;
        }
    }

    public static void testLinkedListStack() {
        Random random = new Random();
        int n = random.nextInt(11) + 20; // Số trong khoảng [20-30]
        System.out.println("Số phần tử n = " + n);

        MyLinkedListStack stack = new MyLinkedListStack();

        // Thêm n phần tử ngẫu nhiên vào stack
        System.out.print("Các phần tử được thêm vào stack: ");
        for (int i = 0; i < n; i++) {
            int value = random.nextInt(100); // Số ngẫu nhiên từ 0-99
            System.out.print(value + " ");
            stack.push(value);
        }
        System.out.println();

        // In ra các phần tử trong stack
        System.out.print("Các phần tử trong stack: ");
        MyLinkedListStack tempStack = new MyLinkedListStack();
        while (!stack.isEmpty()) {
            int value = stack.pop();
            System.out.print(value + " ");
            tempStack.push(value);
        }
        System.out.println();

        // Khôi phục stack
        while (!tempStack.isEmpty()) {
            stack.push(tempStack.pop());
        }

        // Lần lượt xóa các phần tử trong stack
        System.out.println("Lần lượt xóa các phần tử trong stack:");
        int count = 1;
        while (!stack.isEmpty()) {
            int popped = stack.pop();
            System.out.println("Pop thứ " + count + ": " + popped);

            // In ra các phần tử còn lại
            System.out.print("Các phần tử còn lại: ");
            tempStack = new MyLinkedListStack();
            if (stack.isEmpty()) {
                System.out.print("(Stack rỗng)");
            } else {
                while (!stack.isEmpty()) {
                    int value = stack.pop();
                    System.out.print(value + " ");
                    tempStack.push(value);
                }
            }
            System.out.println();

            // Khôi phục stack
            while (!tempStack.isEmpty()) {
                stack.push(tempStack.pop());
            }

            count++;
        }
    }

    public static void testArrayQueue() {
        Random random = new Random();
        int n = random.nextInt(11) + 20; // Số trong khoảng [20-30]
        System.out.println("Số phần tử n = " + n);

        MyArrayQueue queue = new MyArrayQueue();

        // Thêm n phần tử ngẫu nhiên vào queue
        System.out.print("Các phần tử được thêm vào queue: ");
        for (int i = 0; i < n; i++) {
            int value = random.nextInt(100); // Số ngẫu nhiên từ 0-99
            System.out.print(value + " ");
            queue.enqueue(value);
        }
        System.out.println();

        // In ra các phần tử trong queue
        System.out.print("Các phần tử trong queue: ");
        MyArrayQueue tempQueue = new MyArrayQueue();
        while (!queue.isEmpty()) {
            int value = queue.dequeue();
            System.out.print(value + " ");
            tempQueue.enqueue(value);
        }
        System.out.println();

        // Khôi phục queue
        while (!tempQueue.isEmpty()) {
            queue.enqueue(tempQueue.dequeue());
        }

        // Lần lượt xóa các phần tử trong queue
        System.out.println("Lần lượt xóa các phần tử trong queue:");
        int count = 1;
        while (!queue.isEmpty()) {
            int dequeued = queue.dequeue();
            System.out.println("Dequeue thứ " + count + ": " + dequeued);

            // In ra các phần tử còn lại
            System.out.print("Các phần tử còn lại: ");
            tempQueue = new MyArrayQueue();
            if (queue.isEmpty()) {
                System.out.print("(Queue rỗng)");
            } else {
                while (!queue.isEmpty()) {
                    int value = queue.dequeue();
                    System.out.print(value + " ");
                    tempQueue.enqueue(value);
                }
            }
            System.out.println();

            // Khôi phục queue
            while (!tempQueue.isEmpty()) {
                queue.enqueue(tempQueue.dequeue());
            }

            count++;
        }
    }

    public static void testLinkedListQueue() {
        Random random = new Random();
        int n = random.nextInt(11) + 20; // Số trong khoảng [20-30]
        System.out.println("Số phần tử n = " + n);

        MyLinkedListQueue queue = new MyLinkedListQueue();

        // Thêm n phần tử ngẫu nhiên vào queue
        System.out.print("Các phần tử được thêm vào queue: ");
        for (int i = 0; i < n; i++) {
            int value = random.nextInt(100); // Số ngẫu nhiên từ 0-99
            System.out.print(value + " ");
            queue.enqueue(value);
        }
        System.out.println();

        // In ra các phần tử trong queue
        System.out.print("Các phần tử trong queue: ");
        MyLinkedListQueue tempQueue = new MyLinkedListQueue();
        while (!queue.isEmpty()) {
            int value = queue.dequeue();
            System.out.print(value + " ");
            tempQueue.enqueue(value);
        }
        System.out.println();

        // Khôi phục queue
        while (!tempQueue.isEmpty()) {
            queue.enqueue(tempQueue.dequeue());
        }

        // Lần lượt xóa các phần tử trong queue
        System.out.println("Lần lượt xóa các phần tử trong queue:");
        int count = 1;
        while (!queue.isEmpty()) {
            int dequeued = queue.dequeue();
            System.out.println("Dequeue thứ " + count + ": " + dequeued);

            // In ra các phần tử còn lại
            System.out.print("Các phần tử còn lại: ");
            tempQueue = new MyLinkedListQueue();
            if (queue.isEmpty()) {
                System.out.print("(Queue rỗng)");
            } else {
                while (!queue.isEmpty()) {
                    int value = queue.dequeue();
                    System.out.print(value + " ");
                    tempQueue.enqueue(value);
                }
            }
            System.out.println();

            // Khôi phục queue
            while (!tempQueue.isEmpty()) {
                queue.enqueue(tempQueue.dequeue());
            }

            count++;
        }
    }
}