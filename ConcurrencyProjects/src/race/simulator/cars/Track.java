package ConcurrencyProjects.src.race.simulator.cars;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class Track extends JComponent implements Observer{
    private int numCars;
    private int numSteps;
    private int[] carPositions;
    private ImageIcon icon = new ImageIcon("ConcurrencyProjects/azul.gif");

    public Track(int numCars, int numSteps) {
        this.numCars = numCars;
        this.numSteps = numSteps;
        carPositions = new int[numCars];
    }

    private void moveCar(int car, int position) {
        if (car < 0 || car >= numCars)
            throw new IllegalArgumentException("invalid car index: " + car);
        if (position < 0 || position > numSteps)
            throw new IllegalArgumentException("invalid position: " + position);
        carPositions[car] = position;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        double deltaY = ((double) getHeight()) / (numCars + 1);
        double deltaX = ((double) getWidth() - icon.getIconWidth()) / numSteps;
        for (int i = 0; i < numCars; i++) {
            g.drawLine(0, (int) (deltaY * (i + 1)), getWidth(),
                    (int) (deltaY * (i + 1)));
            g.drawImage(icon.getImage(), (int) (carPositions[i] * deltaX),
                    (int) (deltaY * (i + 1)) - icon.getIconHeight(), null);
        }
    }

    @Override
    public void update(Observable arg0, Object arg1) {
        Car updatedCar=(Car)arg0;
        moveCar(updatedCar.getId(), updatedCar.getPosition());
        // Redraw everything!
        invalidate();
    }
}

