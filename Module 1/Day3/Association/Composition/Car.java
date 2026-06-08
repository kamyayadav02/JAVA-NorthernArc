package Composition;

public class Car {
    private Engine engine;
    private AirConditioner ac;
    private  MusicSystem ms;

    public Car(Engine engine, AirConditioner ac, MusicSystem ms) {
        this.engine = engine;
        this.ac = ac;
        this.ms = ms;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public AirConditioner getAc() {
        return ac;
    }

    public void setAc(AirConditioner ac) {
        this.ac = ac;
    }

    public MusicSystem getMs() {
        return ms;
    }

    public void setMs(MusicSystem ms) {
        this.ms = ms;
    }
    public void getDetails(){

        System.out.println("Car Details:");
        System.out.println("Engine HorsePower: " + engine.getHorsePower());
        System.out.println("Air Conditioner Capacity (tons): " + ac.getTons());
        System.out.println("Music System Brand: " + ms.getBrand());

    }
}
