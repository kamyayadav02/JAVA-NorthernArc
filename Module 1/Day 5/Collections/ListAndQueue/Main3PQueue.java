package listAndQueue;

import java.util.PriorityQueue;
import java.util.Queue;

public class Main3PQueue {
    public static void main(String[] args) {
        Queue<Integer> q=new PriorityQueue<>();
        q.add(10);
        q.add(2);
        q.add(300);
        q.add(400);
        System.out.println("Removing: " +q.remove());
        System.out.println("Removing: " +q.remove());
        System.out.println("Removing: " +q.remove());
        System.out.println("Removing: " +q.remove());
    }
}
