package listAndQueue;

import java.util.*;

public class ProductQueueMain {

    public static void main(String[] args) {

        Queue<ProductQueue> q = new LinkedList<>();

        q.add(new ProductQueue("Laptop", 75000, 5));
        q.add(new ProductQueue("Mobile", 25000, 10));
        q.add(new ProductQueue("Tablet", 30000, 7));
        q.add(new ProductQueue("Monitor", 15000, 4));
        q.add(new ProductQueue("Keyboard", 2000, 15));
        q.add(new ProductQueue("Mouse", 800, 20));


        System.out.println("Removed: " + q.remove());
        System.out.println("Removed: " + q.remove());

        System.out.println("Queue after removal: " + q);

        List<ProductQueue> list = new ArrayList<>(q);

        Scanner sc = new Scanner(System.in);

        System.out.println("Choose sorting:");
        System.out.println("1: Name Asc");
        System.out.println("2: Price Asc");
        System.out.println("3: Quantity Asc");

        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                Collections.sort(list, Comparator.comparing(ProductQueue::getName));
                break;

            case 2:
                Collections.sort(list, Comparator.comparingDouble(ProductQueue::getPrice));
                break;

            case 3:
                Collections.sort(list, Comparator.comparingInt(ProductQueue::getQuantity));
                break;

            default:
                System.out.println("Invalid choice");
        }

        System.out.println("Sorted List: " + list);

        sc.close();
    }
}