package ConcurrencyProjects.src.sincronization;

import java.util.ArrayList;
import java.util.LinkedList;

public class SynchronizedQueue {

    public class QueueManager extends Thread {
        private SynchronizedQueue queue;

        public QueueManager(SynchronizedQueue queue) {
            this.queue = queue;
        }

        public SynchronizedQueue getQueue() {
            return queue;
        }

        @Override
        public void run() {
            int repetitions = 2001;
            for(int i = 1; i <= repetitions; i++) {
                queue.offer(i);
            }
        }
    }

    private ArrayList<Integer> queue = new ArrayList<>();

    public boolean empty() {
        return queue.isEmpty();
    }

    public synchronized int peek() {
        if(queue.isEmpty()) throw new IllegalStateException();
        return queue.get(0);
    }

    public synchronized int poll() {
        if(queue.isEmpty()) throw new IllegalStateException();
        int i = queue.get(0);
        queue.remove(0);
        return i;
    }

    public synchronized void offer(int item) {
        queue.add(item);
    }

    public int size() {
        return queue.size();
    }

    public static void main(String[] args) {

        SynchronizedQueue queue = new SynchronizedQueue();

        QueueManager[] managers = new QueueManager[6];
        for(int i = 0; i < 6; i++) {
            managers[i] = queue.new QueueManager(queue);
            managers[i].start();
        }

        for (QueueManager manager : managers) {
            try {
                manager.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Final queue size: " + queue.size());

    }


}
