package polymorphism.challenge;

public class HybridCar extends Car {

    private double avgKmPerLitre;
    private int cylinders;
    private int batterySize;
    public HybridCar(String description, double avgKmPerLitre, int cylinders, int batterySize) {
        super(description);
        this.avgKmPerLitre = avgKmPerLitre;
        this.cylinders = cylinders;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " with " + batterySize + " battery size and " + avgKmPerLitre + " average km per litre";
    }

    @Override
    void startEngine() {
        System.out.println("Starting hybrid car engine...");
    }

    @Override
    protected void runEngine() {
        System.out.println("Running hybrid car engine...");
    }

    @Override
    void brake() {
        System.out.println("Braking hybrid car...");
    }

    @Override
    void stopEngine() {
        System.out.println("Stopping hybrid car engine...");
    }

}
