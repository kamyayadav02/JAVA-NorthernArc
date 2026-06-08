package Interfacedemo;

public interface Shape {
    String colour = " red";

    static void showColour() {

    }

    void calculateArea();
    public static void main(String[] args){
        System.out.println("The colour of shape is " + colour);
    }
}
