public class Lion extends Animal {

    public Lion(String name, String type, int age) {
        super(name, type, age);
    }

    @Override
    public void eat() {
        System.out.println(getName() + " eats as a carnivore.");
    }

    @Override
    public void talk() {
        System.out.println(getName() + " roars.");
    }
}