package polymorphism.challenge;

public abstract class Car {
    private String description;

    public Car(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
    abstract void startEngine();
    protected abstract void runEngine();
    abstract void brake();
    abstract void stopEngine();
}
