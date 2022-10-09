package module9;

import java.util.Arrays;

public class MyStack {
    private int arr[];
    private int top;
    private int capacity;

    public MyStack(int size){
        arr = new int[size];
        capacity = size;
        top = -1;
    }

    public void push(int x){
        if (isFull())
        {
            System.out.println("Overflow\nProgram Terminated\n");
            System.exit(-1);
        }

        System.out.println("Inserting " + x);
        arr[++top] = x;
    }

    public int pop(){
        // проверка на опустошение stack
        if (isEmpty())
        {
            System.out.println("Underflow\nProgram Terminated");
            System.exit(-1);
        }

        System.out.println("Removing " + peek());

        return arr[top--];
    }

    public int peek(){
        if (!isEmpty()) {
            return arr[top];
        }
        else {
            System.exit(-1);
        }

        return -1;
    }

    public int size() {
        return top + 1;
    }

    public boolean remove(int index) {
        if (isEmpty()) {
            System.out.println("Underflow\nProgram Terminated");
            System.exit(-1);
        }

        for (int i = index; i < arr.length; i++) {
            if (arr[i] == arr[index]) {
                for (int j = index; j < arr.length; j++) {
                    arr[i] = arr[j];

                }
                capacity--;
            }
            arr = Arrays.copyOf(arr,arr.length -1);
            return true;
        }
        return false;
    }

    public void clear() {
        if (isEmpty()) {
            System.out.println("Underflow\nProgram Terminated");
            System.exit(-1);
        }
        for(int i = 0; i < arr.length; i++){
            arr[i] = 0;
            capacity--;
        }
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == capacity - 1;
    }
}
