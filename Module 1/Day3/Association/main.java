package association2;

import association.Passport;
import association.Person;

public class main {
    public static void main(String[] args) {

        association.Person p = new Person("John", "Doe");

        association.Passport pass = new Passport("P123456", "USA", "01-01-2020", "01-01-2030");

        pass.setPerson(p);
        System.out.println(pass);
    }
}
