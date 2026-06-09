package Iteration;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class QueueIterator {
    public static void main(String[] args) {

        Queue<String> queue = new LinkedList<>();

        queue.add("Sachin");
        queue.add("Sourav");
        queue.add("Sam");
        queue.add("Mahesh");
        queue.add("Raghav");

        System.out.println("-------------------------");

        for (String str : queue) {
            System.out.println(str);
        }


        Iterator<String> itr = queue.iterator();

        System.out.println(itr.getClass().getName());
        System.out.println();

        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
    }
}
