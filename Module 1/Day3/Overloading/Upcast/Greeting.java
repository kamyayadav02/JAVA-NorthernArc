package upcast;

public class Greeting {
    public void greet(){

        System.out.println("Hello");
    }
    public void greet(Person p){

        System.out.println("Hello" );
    }
    public void greet(Student s){

        System.out.println("Hello" );
    }
    public void greet(Employee e){

        System.out.println("Hello" );
    }

}
