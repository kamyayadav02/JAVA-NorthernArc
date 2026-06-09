package Set;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class Main1 {
    public static void main(String[] args) {
        //Set<Integer> set=new LinkedHashSet<>(); // in the same order in which you wrote
        Set<Integer> set=new HashSet<>(); //duplicates not allowed
       // Set<Integer> set=new TreeSet<>();  //gives ordered
        set.add(100);
        set.add(10);
        set.add(1);
        set.add(400);
        set.add(400);
        System.out.println("Set: " + set);
    }
}
