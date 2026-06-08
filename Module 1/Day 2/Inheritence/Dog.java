public class Dog extends Animal {

    public Dog(String name, String type, int age) {
        super(name, type, age);
    }

    @Override
    public void eat() {
        System.out.println(getName() + " is omnivorous.");
    }

    @Override
    public void talk() {
        System.out.println(getName() + " barks.");
    }
}
