package listAndQueue;

import java.util.PriorityQueue;
import java.util.Queue;

public class Main5PQueue {
    public static void main(String[] args) {
        Queue<String> q=new PriorityQueue<>();
        q.add("Hi");
        q.add("Hello");
        q.add("Hey");
        q.add("Bye");
        System.out.println("Removing: " +q.remove());
        System.out.println("Removing: " +q.remove());
        System.out.println("Removing: " +q.remove());
        System.out.println("Removing: " +q.remove());
    }
}
