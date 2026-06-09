package Set;

import java.util.HashSet;
import java.util.Set;

public class MainPerson {
    public static void main(String[] args) {
        Set<Person> set=new HashSet<>();
        set.add(new Person("Sachin","Tendulkar",24));
        set.add(new Person("Sachin","Tendulkar",24));
        set.add(new Person("Sachin","Tendulkar",24));
        set.add(new Person("Sachin","Tendulkar",24));
        System.out.println(set.toString());
    }
}
