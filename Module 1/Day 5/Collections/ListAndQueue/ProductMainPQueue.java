package listAndQueue;

import java.util.*;

public class ProductMainPQueue {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter choice: 1, 2 or 3");
        int choice = sc.nextInt();

        Comparator<ProductPQueue> comparator;

        switch (choice) {

            case 1:
                comparator = (p1, p2) -> Double.compare(p1.getPrice(), p2.getPrice());
                break;

            case 2:
                comparator = (p1, p2) -> p1.getName().compareToIgnoreCase(p2.getName());
                break;

            case 3:
                comparator = (p1, p2) -> Integer.compare(p1.getQuantity(), p2.getQuantity());
                break;

            default:
                comparator = (p1, p2) -> Double.compare(p1.getPrice(), p2.getPrice());
        }

        PriorityQueue<ProductPQueue> pq = new PriorityQueue<>(comparator);

        pq.add(new ProductPQueue("Laptop", 75000, 5));
        pq.add(new ProductPQueue("Mobile", 25000, 10));
        pq.add(new ProductPQueue("Tablet", 30000, 7));
        pq.add(new ProductPQueue("Monitor", 15000, 4));

        System.out.println("Sorted Output:");

        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }

        sc.close();
    }
}