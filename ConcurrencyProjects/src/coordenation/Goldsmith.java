package ConcurrencyProjects.src.coordenation;

import javax.swing.*;

public class Goldsmith extends Thread {

    private Balance balance;
    private int ingots = 0;

    public Goldsmith(Balance balance) {
        this.balance = balance;
    }

    @Override
    public void run() {
        System.out.println("Goldsmith: " + Thread.currentThread().toString() +
                " I've started running");
        while (true) {
            try {
                balance.remove();
                System.out.println("Goldsmith: " + Thread.currentThread().toString() +
                        " I'm about to go to sleep for 3 seconds");
                sleep(3000);
                System.out.println("Goldsmith: " + Thread.currentThread().toString() +
                        " I'm now awake");
                ingots++;
                System.out.println("Goldsmith: " + Thread.currentThread().toString() +
                        " I've stopped running and the number of ingots is " + ingots);
            } catch (InterruptedException e) {
                System.out.println("Goldsmith: " + Thread.currentThread().toString()
                + " I've been interrupted");
                System.out.println(ingots);
                break;
            }
        }
    }
}
