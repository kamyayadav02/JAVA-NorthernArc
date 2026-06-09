package listAndQueue;
import java.util.ArrayDeque;
import java.util.Deque;
public class DequeueString {
    public static void main(String[] args) {
        ArrayDeque<Object> dequeue= new ArrayDeque<>();
        dequeue.addFirst("Hi");
        dequeue.addFirst("Hello");
        dequeue.addFirst("Hey");
        dequeue.addFirst("Hola");
        System.out.println("Dequeue: " + dequeue );
        System.out.println("Remove first: " + dequeue.removeFirst());
        System.out.println("Remove last: " + dequeue.removeLast());
        System.out.println("Peek First: " + dequeue.peekFirst());
        System.out.println("Peek Last: " + dequeue.peekLast());
    }
}
