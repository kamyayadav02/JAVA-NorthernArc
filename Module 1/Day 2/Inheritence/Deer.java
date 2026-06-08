public class Deer extends Animal{
    public Deer(String name, String type, int age) {
        super(name, type, age);
    }
    @Override
    public void eat() {
        System.out.println(getName() + " is herbivorous.");
    }
    @Override
    public void talk() {
        System.out.println(getName() + " also makes sound.");
    }
}
