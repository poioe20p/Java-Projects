package ConcurrencyProjects.src.coordenation;

import javax.swing.*;

public class Balance {
    private double weight = 0;
    JTextField weightField = new JTextField();

    public synchronized void put(double gold) throws InterruptedException {
        while(weight >= 12.5) {
            System.out.println("Excavator: " + Thread.currentThread().toString() + " i'm waiting to add more gold");
            wait();
            System.out.println("Excavator: " + Thread.currentThread().toString() + " i'm going to add more gold");
        }
        weight = weight + gold;
        weightField.setText(String.valueOf(weight));
        notifyAll();
    }

    public synchronized void remove() throws InterruptedException {
        while(weight < 12.5) {
            System.out.println("Goldsmith: " + Thread.currentThread().toString() + " i'm to take gold");
            wait();
            System.out.println("Goldsmith: " + Thread.currentThread().toString() + " i'm about to some take gold");
        }
        weight = weight - 12.5;
        weightField.setText(String.valueOf(weight));
        notifyAll();
    }

    public JTextField getTextField() {
        return weightField;
    }
}
