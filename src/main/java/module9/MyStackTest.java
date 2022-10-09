package module9;

public class MyStackTest {


    public static void main(String[] args) {
        MyStack myStack = new MyStack(3);

        myStack.push(1);
        myStack.push(2);

        myStack.pop();
        myStack.pop();

        myStack.push(3);

        System.out.println("The top element is " + myStack.peek());
        System.out.println("The stack size is " + myStack.size());

        myStack.remove(2);
        System.out.println("The stack size is " + myStack.size());

        myStack.clear();

        if (myStack.isEmpty()) {
            System.out.println("The stack is empty");
        }
        else {
            System.out.println("The stack is not empty");
        }
    }
}

