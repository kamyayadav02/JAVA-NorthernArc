package listAndQueue;

import java.util.LinkedList;
import java.util.Queue;

public class Main2Queue {
    public static void main(String[] args) {
        Queue<Integer> queue =new LinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        System.out.println("Removing: " + queue.remove());
        System.out.println("Removing: " + queue.remove());
        System.out.println("Removing: " + queue.remove());
        System.out.println("Peeking: " + queue.peek());  //peak will only return the value not remove
    }
}
