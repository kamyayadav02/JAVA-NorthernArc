package listAndQueue;
import java.util.ArrayDeque;
import java.util.Deque;

public class DequeueInteger {
    public static void main(String[] args) {


                Deque<Integer> deque = new ArrayDeque<>();

                deque.addFirst(1);
                deque.addLast(2);
                deque.addLast(3);
                deque.addFirst(0);

                System.out.println("Deque: " + deque);

                System.out.println("Remove First: " + deque.removeFirst());
                System.out.println("Remove Last: " + deque.removeLast());

                System.out.println("Peek First: " + deque.peekFirst());
                System.out.println("Peek Last: " + deque.peekLast());
            }
        }

