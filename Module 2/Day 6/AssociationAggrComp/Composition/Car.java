package Composition;

public class Car {
    private Engine engine;
    private String model;

    public Car(int horsePower, String model) {
        this.engine = new Engine(horsePower);
        this.model = model;
    }
    public void start(){
        System.out.println("Car is starting........");
        engine.start();
    }
}
