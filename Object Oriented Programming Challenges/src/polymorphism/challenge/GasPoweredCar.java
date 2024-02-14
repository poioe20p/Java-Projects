package polymorphism.challenge;

public class GasPoweredCar extends Car {
    private double avgKmPerLitre;
    private int cylinders;

    public GasPoweredCar(String description, double avgKmPerLitre, int cylinders) {
        super(description);
        this.avgKmPerLitre = avgKmPerLitre;
        this.cylinders = cylinders;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " with " + cylinders + " cylinders and " + avgKmPerLitre + " average km per litre";
    }

    @Override
    void startEngine() {
        System.out.println("Starting gas powered car engine...");
    }

    @Override
    protected void runEngine() {
        System.out.println("Running gas powered car engine...");
    }

    @Override
    void brake() {
        System.out.println("Braking gas powered car...");
    }

    @Override
    void stopEngine() {
        System.out.println("Stopping gas powered car engine...");
    }
}
