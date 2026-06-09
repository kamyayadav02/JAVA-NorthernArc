package interconversion;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class listToSet {
    public static void main(String[] args) {
        List<Integer> list=new ArrayList<>();
        list.add(20);
        list.add(40);
        list.add(30);
        list.add(50);
        list.add(40);
        System.out.println(list);
        Set<Integer> set=new LinkedHashSet<>(list);
        System.out.println(set);
        System.out.println("___________________");
        list=new ArrayList<>(set);
        System.out.println(set);
        System.out.println("___________________");
        System.out.println(list instanceof Set);
        System.out.println(list instanceof List);


    }
}
