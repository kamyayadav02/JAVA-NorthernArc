package listAndQueue;

import java.util.*;

public class PersonMainPQueue {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter choice: 1,2 or 3");
        int choice= sc.nextInt();


        choice = 1;

        Comparator<PersonPQueue> comparator;

        switch (choice) {

            case 1:
                comparator = (p1, p2) -> p1.getAge() - p2.getAge();
                break;

            case 2:
                comparator = (p1, p2) -> p1.getFname().compareToIgnoreCase(p2.getFname());
                break;

            case 3:
                comparator = (p1, p2) -> p1.getLname().compareToIgnoreCase(p2.getLname());
                break;

            default:
                comparator = (p1, p2) -> p1.getAge() - p2.getAge();
        }

        PriorityQueue<PersonPQueue> pq = new PriorityQueue<>(comparator);


        pq.add(new PersonPQueue("John", "Doe", 30));
        pq.add(new PersonPQueue("Alice", "Smith", 25));
        pq.add(new PersonPQueue("Bob", "Brown", 35));
        pq.add(new PersonPQueue("Charlie", "Adams", 28));

        System.out.println("Sorted Output:");

        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }
    }
}