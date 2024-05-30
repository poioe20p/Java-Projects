package ConcurrencyProjects.src.sincronization;

public class Counter {

    public class Incrementer extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 1000; i++)
                increments();
        }

    }

    private int count = 0;

    public int getCount() {
        return count;
    }

    public synchronized void increments() {
        count++;
    }

    public static void main(String[] args) {
        Thread[] threads = new Thread[4];
        Counter counter = new Counter();
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

