package listAndQueue;

import java.util.Collections;
import java.util.List;
import java.util.Vector;

public class Main2 {
    public static void main(String[] args) {
        List<Double>  list= new Vector<Double>();
        list.add(100.78);
        list.add(12.5);
        list.add(13.26);
        list.add(4.98);
        list.add(5.28);
        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));
        list.set(0, 5.0);
        list.remove(4);
        list.remove(3);
        System.out.println(list);
        //list sort
        Collections.sort(list ,Collections.reverseOrder()); // if you want reverse order
        System.out.println(list);
    }
}
