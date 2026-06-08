package Interfacedemo;

public interface Animal {
    String type = "Wild Animal";

    static void showType() {
        System.out.println("Animals belong to category: " + type);
    }

    void talk();
    void eat();

    public static void main(String[] args) {
        System.out.println("Animal type is " + type);
    }
}
