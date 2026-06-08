package Interfacedemo;

public class Main1 {
    public static void main(String[] args){
        Circle c=new Circle(10);
        c.calculateArea();
        Rectangle r=new Rectangle(10,20);
        r.calculateArea();
        Triangle t= new Triangle(10,5);
        t.calculateArea();
        System.out.println(Shape.colour);
        Shape.showColour();
    }
}
