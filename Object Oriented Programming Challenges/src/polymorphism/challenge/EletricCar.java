package polymorphism.challenge;

public class EletricCar extends Car {

    private double avgKmPerCharge;
    private int batterySize;
    public EletricCar(String description, double avgKmPerCharge, int batterSize) {
        super(description);
        this.avgKmPerCharge = avgKmPerCharge;
        this.batterySize = batterSize;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " with " + batterySize + " battery size and " + avgKmPerCharge + " average km per charge";
    }

    @Override
    void startEngine() {
        System.out.println("Starting electric car engine, so silent...");
    }

    @Override
    protected void runEngine() {
        System.out.println("Running electric car engine...");
    }

    @Override
    void brake() {
        System.out.println("Braking electric car...");
    }

    @Override
    void stopEngine() {
        System.out.println("Stopping electric car engine...");
    }
}
