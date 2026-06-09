package listAndQueue;

import java.util.*;

public class PersonQueueMain {
    public static void main(String[] args) {

        Queue<PersonQueue> q = new LinkedList<>();

        q.add(new PersonQueue("Sachin", "Tendulkar", 26));
        q.add(new PersonQueue("Sourav", "Ganguly", 24));
        q.add(new PersonQueue("Rahul", "Tendulkar", 29));
        q.add(new PersonQueue("Yuvraj", "Tendulkar", 21));
        q.add(new PersonQueue("Abhishek", "Tendulkar", 25));
        q.add(new PersonQueue("Virat", "Kohli", 36));

        System.out.println("Removed: " + q.remove());
        System.out.println("Removed: " + q.remove());

        System.out.println("Queue after removal: " + q);

        List<PersonQueue> list = new ArrayList<>(q);

        Scanner sc = new Scanner(System.in);

        System.out.println("Choose sorting:");
        System.out.println("1: fname Asc");
        System.out.println("2: lname Asc");
        System.out.println("3: age Asc");

        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                Collections.sort(list, Comparator.comparing(PersonQueue::getFname));
                break;
            case 2:
                Collections.sort(list, Comparator.comparing(PersonQueue::getLname));
                break;
            case 3:
                Collections.sort(list, Comparator.comparingInt(PersonQueue::getAge));
                break;
            default:
                System.out.println("Invalid choice");
        }

        System.out.println("Sorted List: " + list);

        sc.close();
    }
}
