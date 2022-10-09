package module9;

public class MyQueueTest {
   public static void main (String[] args)
    {
        MyQueue myQueue = new MyQueue(5);
        myQueue.add(1);
        myQueue.add(2);
        myQueue.add(3);
        System.out.println("The front element is " + myQueue.peek());
        myQueue.poll();
        System.out.println("The front element is " + myQueue.peek());

        System.out.println("The queue size is " + myQueue.size());

        myQueue.remove(2);
        System.out.println("The queue size is " + myQueue.size());

        myQueue.clear();
    }
}
