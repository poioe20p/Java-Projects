package ConcurrencyProjects.src.coordenation;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Thread.sleep;

public class Table {

    public record Boar(int id, Chef chef) {

        @Override
        public String toString() {
            return "Boar [id=" + id + ", chef=" + chef + "]";
        }
    }

    private final List<Boar> boars = new ArrayList<>();
    public final static int CAPACITY = 10;
    public final static int NUM_CHEFS = 5;
    public final static int NUM_GAULS = 10;

    public synchronized void put(Boar boar) {
        while(boars.size() == CAPACITY) {
            try {
                System.out.println("Chef is waiting");
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        boars.add(boar);
        notifyAll();
    }

    public synchronized Boar take() throws InterruptedException {
        while(boars.isEmpty()) {
            System.out.println("Gaul is waiting");
            wait();
        }
        notifyAll();
        return boars.remove(0);
    }

    public class Chef extends Thread {
        @Override
        public String toString() {
            return "Chef: " + getId();
        }

        @Override
        public  void run() {
            int i = 0;
            while(true) {
                i++;
                put(new Boar(i, this));
            }
        }
    }

    public class Gaul extends Thread {
        @Override
        public void run() {
            while(true) {
                try {
                    System.out.println("Was consumed: " + take());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public static void main(String[] args) {
        List<Thread> threads = new ArrayList<>();
        Table table = new Table();
        for (int  i = 0; i < NUM_CHEFS; i++) {
            threads.add(table.new Chef());
            threads.get(threads.size()-1).start();
        }
        for (int  i = 0; i < NUM_GAULS; i++) {
            threads.add(table.new Gaul());
            threads.get(threads.size()-1).start();
        }
        try {
            sleep(5000);
        } catch (InterruptedException ignored) {
        }
        for(Thread t: threads) {
            t.interrupt();
        }
    }
}
