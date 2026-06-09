package listAndQueue;

import java.util.LinkedList;
import java.util.Queue;

public class Main4Queue {
    public static void main(String[] args) {
        Queue<String> queue =new LinkedList<>();
        queue.add("Hi");
        queue.add("Hello");
        queue.add("Hey");
        queue.add("Bye");
        System.out.println("Removing: " + queue.remove());
        System.out.println("Removing: " + queue.remove());
        System.out.println("Removing: " + queue.remove());
        System.out.println("Peeking: " + queue.peek());  //peak will only return the value not remove
    }
}
