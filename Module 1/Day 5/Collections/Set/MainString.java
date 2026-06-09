package Set;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class MainString {
    public static void main(String[] args) {
        Set<String> set=new LinkedHashSet<>(); //in the same order in which you wrote
        //Set<String> set=new HashSet<>(); //duplicates not allowed
        //Set<String> set=new TreeSet<>();  //gives ordered
        set.add("Hi");
        set.add("Hello");
        set.add("Hey");
        set.add("Bye");
        set.add("Goodbye");
        System.out.println("Set: " + set);
    }
}
