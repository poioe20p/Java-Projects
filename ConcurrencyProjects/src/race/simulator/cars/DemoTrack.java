package ConcurrencyProjects.src.race.simulator.cars;

import javax.swing.*;

public class DemoTrack {

    public static void main(String[] args) {
        // GUI usage example... Change to suit exercise
        JFrame frame = new JFrame("Demo Track");
        Track track = new Track(3, 100);
        Car c0=new Car(0, 100);
        Car c1=new Car(1, 100);
        Car c2=new Car(2, 100);
        c1.addObserver(track);
        c2.addObserver(track);
        c0.addObserver(track);

        frame.add(track);
        frame.setSize(500, 300);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

}

