package Module12;


import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;


public class FizzBuzz {
    private int n;
    private Semaphore lock;
    private AtomicInteger counter;
    public FizzBuzz(int n) {
        this.n = n;
        this.lock = new Semaphore(1);
        this.counter = new AtomicInteger(1);
    }

    public void fizz() throws InterruptedException {
        int step = n/3 - n/15;
        int i = 0;
        while (i < step) {
        lock.acquire();
        if (counter.get() % 3 == 0 && counter.get() % 15 != 0) {
            System.out.println("fizz");
            counter.incrementAndGet();
            i++;
        }
        lock.release();
       }
    }

    public void buzz() throws InterruptedException {
        int step = n/5 - n/15;
        int i = 0;
        while (i < step) {
            lock.acquire();
            if (counter.get() % 5 == 0 && counter.get() % 15 != 0) {
                System.out.println("buzz");
                counter.incrementAndGet();
                i++;
            }
            lock.release();
        }
    }

    public void fizzbuzz() throws InterruptedException {
        int step = n/15;
        int i = 0;
        while (i < step) {
            lock.acquire();
            if (counter.get() % 15 == 0) {
                System.out.println("fizzbuzz");
                counter.incrementAndGet();
                i++;
            }
            lock.release();
        }
    }

    public void number() throws InterruptedException {
        int step = n - n/3 - n/5 + n/15;
        int i = 0;
        while (i < step) {
            lock.acquire();
            if (counter.get() % 3 != 0 && counter.get() % 5 != 0) {
               System.out.println(counter.get());
                counter.incrementAndGet();
                i++;
            }
            lock.release();
        }
    }
}
