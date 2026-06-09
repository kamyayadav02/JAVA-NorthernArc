package listAndQueue;

import java.util.*;

public class ProductListMain {
    public static void main(String[] args) {

        // Creating List
        List<ProductList> list = new Vector<>();

        // Adding products
        list.add(new ProductList(1, "Pen", "Stationary", "GelPens", 50, 5, 10));
        list.add(new ProductList(2, "Pencil", "Stationary", "Natraj", 20, 4, 9));
        list.add(new ProductList(3, "Eraser", "Stationary", "Apsara", 10, 3, 6));
        list.add(new ProductList(4, "Sharpener", "Stationary", "Local", 10, 2, 3));
        list.add(new ProductList(5, "Scale", "Stationary", "Natraj", 15, 1, 8));

        // Printing first 3 items
        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));

        // Using set()
        list.set(0, new ProductList(6, "Compass", "Stationary", "Local", 40, 10, 10));

        // Using remove()
        list.remove(4);
        list.remove(3);

        System.out.println("After modification: " + list);

        // Sorting Part
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a number:");
        System.out.println("1: sort by Name");
        System.out.println("2: sort by Brand");
        System.out.println("3: sort by Price");
        System.out.println("4: sort by Rating");
        System.out.println("5: sort by Discount");

        int num = sc.nextInt();

        switch (num) {

            case 1:
                Collections.sort(list, new Comparator<ProductList>() {
                    public int compare(ProductList o1, ProductList o2) {
                        return o1.getName().compareTo(o2.getName());
                    }
                });
                break;

            case 2:
                Collections.sort(list, new Comparator<ProductList>() {
                    public int compare(ProductList o1, ProductList o2) {
                        return o1.getBrand().compareTo(o2.getBrand());
                    }
                });
                break;

            case 3:
                Collections.sort(list, new Comparator<ProductList>() {
                    public int compare(ProductList o1, ProductList o2) {
                        return o1.getPrice() - o2.getPrice();
                    }
                });
                break;

            case 4:
                Collections.sort(list, new Comparator<ProductList>() {
                    public int compare(ProductList o1, ProductList o2) {
                        return o1.getRating() - o2.getRating();
                    }
                });
                break;

            case 5:
                Collections.sort(list, new Comparator<ProductList>() {
                    public int compare(ProductList o1, ProductList o2) {
                        return o1.getDiscount() - o2.getDiscount();
                    }
                });
                break;

            default:
                System.out.println("Invalid choice");
        }

        System.out.println("Sorted List: " + list);

        sc.close();
    }
}