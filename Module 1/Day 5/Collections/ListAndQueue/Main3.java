package listAndQueue;

import java.util.Collections;
import java.util.List;
import java.util.Vector;

public class Main3 {
    public static void main(String[] args) {
        List<String> list= new Vector<String>();
        list.add("Hi");
        list.add("Hello");
        list.add("Goodbye");
        list.add("Bonjour");
        list.add("bye");
        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));
        list.set(0, String.valueOf(5));
        list.remove(4);
        list.remove(3);
        System.out.println(list);
        //list sort
        Collections.sort(list);
        System.out.println(list);
    }
}
