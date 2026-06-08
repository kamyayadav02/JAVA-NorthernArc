public class Animal {

    private String name;
    private String type;
    private int age;

    public Animal(String name, String type, int age) {
        this.name = name;
        this.type = type;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getAge() {
        return age;
    }

    public void eat() {
        System.out.println(name + " eats food.");
    }

    public void walk() {
        System.out.println(name + " walks.");
    }

    public void talk() {
        System.out.println(name + " makes sound.");
    }

    public void getDetails() {
        System.out.println("Name: " + name + " Type: " + type + " Age: " + age);
    }
}