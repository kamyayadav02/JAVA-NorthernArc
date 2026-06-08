package covariant;

public class Main {
    public static void main(String[] args){
        Person p=new Person("John", "Doe");
        Student s=new Student("John", "Doe","Java");
        Person p1=p.getDemo();
        Student s1= s.getDemo();
        System.out.println(p1.getLname());
    }
}
