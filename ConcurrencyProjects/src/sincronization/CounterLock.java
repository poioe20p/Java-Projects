package ConcurrencyProjects.src.sincronization;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CounterLock {

    public class Incrementer extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 1000; i++)
                increments();
        }
    }

    private int count = 0;
    private final Lock lock = new ReentrantLock();

    public int getCount() {
        return count;
    }

    public synchronized void increments() {
        lock.lock();
        try {
            count++;
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        Thread[] threads = new Thread[4];
        CounterLock counter = new CounterLock();
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

