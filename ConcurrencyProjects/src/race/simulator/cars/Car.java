package ConcurrencyProjects.src.race.simulator.cars;

import java.util.Observable;

public class Car extends Observable implements Runnable{
    private int id;
    private int limit;
    private int position=0;

    public int getId() {
        return id;
    }

    public int getPosition() {
        return position;
    }

    public Car(int id, int limit) {
        super();
        this.id = id;
        this.limit = limit;
    }


    @Override
    public void run() {
        position++;
    }

    @Override
    protected synchronized void setChanged() {
        super.setChanged();
    }

    @Override
    public void notifyObservers() {
        super.notifyObservers();
    }
}

