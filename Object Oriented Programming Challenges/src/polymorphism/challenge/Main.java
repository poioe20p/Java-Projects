package polymorphism.challenge;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Car car = new EletricCar("Tesla Model S", 500, 100);
        Car car1 = new HybridCar("Toyota Prius", 20, 4, 50);
        Car car2 = new GasPoweredCar("Ford Fusion", 10, 4);

        ArrayList<Car> cars = new ArrayList<>(List.of(car, car1, car2));
        for (Car c : cars) {
            System.out.println(c.getDescription());
            c.startEngine();
            c.runEngine();
            c.brake();
            c.stopEngine();
            System.out.println();
            if(c instanceof EletricCar) {
                System.out.println("I love electric cars!");
                System.out.println();
            } else if(c instanceof HybridCar) {
                System.out.println("I love hybrid cars!");
                System.out.println();
            } else if(c instanceof GasPoweredCar) {
                System.out.println("I love gas powered cars!");
                System.out.println();
            }
        }
    }
}
