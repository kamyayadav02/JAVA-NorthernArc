package listAndQueue;
import java.util.*;

public class Main1 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>(); //instead of ArrayList you can use LinkedList also as both classes implement list only
        list.add(100);                                 //only difference of contiguous and not contiguous memory
        list.add(12);
        list.add(13);
        list.add(4);
        list.add(5);
        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));
        list.set(0,5);
        list.remove(4);
        list.remove(3);
        System.out.println(list);
        //list sort
        Collections.sort(list);
        System.out.println(list);
    }
}
