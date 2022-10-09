package module9;
import java.util.*;

public class MyQueue {
    private int[] queue;
    private int maxSize;
    private int count;
    private int front;
    private int rear;

    public MyQueue(int maxSize) {
        this.maxSize = maxSize;
        queue = new int[maxSize];
        rear = -1;
        front = 0;
        count = 0;
    }

    public void add(int elem) {
        if (rear == maxSize - 1) { rear = -1; }

        queue[++rear] = elem;
        count++;
    }

    public void clear() {
        if (isEmpty()) {
            System.out.println("Underflow\nProgram Terminated");
            System.exit(-1);
        }
        for(int i = 0; i < queue.length; i++){
            queue[i] = 0;
            count--;
        }
    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return (size() == 0);
    }

    public int peek() {
        if (isEmpty())
        {
            System.out.println("Underflow\nProgram Terminated");
            System.exit(-1);
        }
        return queue[front];
    }

    public int poll() {
        if (isEmpty()) {
            System.out.println("Underflow\nProgram Terminated");
            System.exit(-1);
        }

        int x = queue[front];

        System.out.println("Removing " + x);

        front = (front + 1) % size();
        count--;

        return x;
    }
    public boolean remove(int index) {
        if (isEmpty()) {
            System.out.println("Underflow\nProgram Terminated");
            System.exit(-1);
        }

        for (int i = index; i < queue.length; i++) {
            if (queue[i] == queue[index]) {
                for (int j = index; j < queue.length; j++) {
                    queue[i] = queue[j];

                }
                count--;
            }
            queue = Arrays.copyOf(queue,queue.length -1);
            return true;
        }
        return false;
    }
}
