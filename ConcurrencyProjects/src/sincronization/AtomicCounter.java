package ConcurrencyProjects.src.sincronization;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AtomicCounter {
    public class Incrementer extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 1000; i++)
                increments();
        }
    }

    private final AtomicInteger count = new AtomicInteger(0);

    public AtomicInteger getCount() {
        return count;
    }

    public synchronized void increments() {
        count.getAndIncrement();
    }

    public static void main(String[] args) {
        Thread[] threads = new Thread[4];
        AtomicCounter counter = new AtomicCounter();
        long start = System.nanoTime();
        for (int i = 0; i < threads.length; i++) {
            threads[i] = counter.new Incrementer();
            threads[i].start();
        }
        for (Thread t: threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
//                    e.printStackTrace();
            }
        }
        System.out.println("Final count: " + counter.getCount()
                + " time: "+ ((System.nanoTime() - start)/1000));
    }
}
