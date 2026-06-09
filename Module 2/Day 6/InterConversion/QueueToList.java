package interconversion;

import java.util.*;

public class QueueToList {
    public static void main(String[] args) {

        Queue<Integer> q = new LinkedList<>();

        q.add(20);
        q.add(40);
        q.add(30);
        q.add(50);
        q.add(40);

        System.out.println(q);

        List<Integer> list = new LinkedList<>(q);
        System.out.println(list);

        System.out.println("___________________");

        q = new LinkedList<>(list);
        System.out.println(q);

        System.out.println("___________________");

        System.out.println(list instanceof Queue);
    }
}