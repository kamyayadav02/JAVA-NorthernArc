package Composition;

public class CarMain {
    public static void main (String[] args){
        Car c=new Car(
                new Engine(100),
                new AirConditioner(1),
                new MusicSystem("Sony"));
        c.getDetails();
    }
}
