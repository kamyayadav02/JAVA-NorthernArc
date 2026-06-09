package arraysDemo;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
public class ProductSort {
    public static void main(String[] args) {
        Product[] product = {
                new Product(1, "pen", "stationary", "gelpens", 50, 5, 10),
                new Product(2, "pencil", "stationary", "Natraj", 20, 4, 9),
                new Product(3, "eraser", "stationary", "Apsara", 10, 3, 6),
                new Product(4, "sharpener", "stationary", "Local", 10, 2, 3),
                new Product(5, "scale", "stationary", "Natraj", 15, 1, 8)
        };
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter a number\n 1: name Asc Comparator\n 2: brand Asc Comparator\n 3: price Asc Comparator\n 4:rating Asc Comparator\n 5:discount Asc comparator\n 6:name Desc comparator\n 7:brand Desc comparator\n 8:price Desc comparator\n 9:rating Desc comparator\n 10:discount Desc comparator\n");
            int num = sc.nextInt();
            switch (num) {
                case 1:
                    Arrays.sort(product, new Comparator<Product>() {
                        @Override
                        public int compare(Product o1, Product o2) {
                            return o1.getName().compareTo(o2.getName());
                        }
                    });
                    System.out.println("name Asc Comparator: " + Arrays.toString(product));
                    break;
                case 2:
                    Arrays.sort(product, new Comparator<Product>() {
                        @Override
                        public int compare(Product o1, Product o2) {
                            return o1.getBrand().compareTo(o2.getBrand());
                        }
                    });
                    System.out.println("brand asc comparator: " + Arrays.toString(product));
                    break;
                case 3:
                    Arrays.sort(product, new Comparator<Product>() {
                        @Override
                        public int compare(Product o1, Product o2) {
                            return o1.getPrice() - o2.getPrice();
                        }
                    });
                    System.out.println("price asc comparator: " + Arrays.toString(product));
                    break;
                case 4:
                    Arrays.sort(product, new Comparator<Product>() {
                        @Override
                        public int compare(Product o1, Product o2) {
                            return o1.getRating() - o2.getRating();
                        }
                    });
                    System.out.println("rating asc comparator: " + Arrays.toString(product));
                    break;
                case 5:
                    Arrays.sort(product, new Comparator<Product>() {
                        @Override
                        public int compare(Product o1, Product o2) {
                            return o1.getDiscount() - o2.getDiscount();
                        }
                    });
                    System.out.println("discount asc comparator: " + Arrays.toString(product));
                    break;
                case 6:
                    Arrays.sort(product, new Comparator<Product>() {
                        @Override
                        public int compare(Product o1, Product o2) {
                            return o2.getName().compareTo(o1.getName());
                        }
                    });
                    System.out.println("name Desc Comparator: " + Arrays.toString(product));
                    break;
                case 7:
                    Arrays.sort(product, new Comparator<Product>() {
                        @Override
                        public int compare(Product o1, Product o2) {
                            return o2.getBrand().compareTo(o1.getBrand());
                        }
                    });
                    System.out.println("brand Desc comparator: " + Arrays.toString(product));
                    break;
                case 8:
                    Arrays.sort(product, new Comparator<Product>() {
                        @Override
                        public int compare(Product o1, Product o2) {
                            return o2.getPrice() - o1.getPrice();
                        }
                    });
                    System.out.println("price Desc comparator: " + Arrays.toString(product));
                    break;
                case 9:
                    Arrays.sort(product, new Comparator<Product>() {
                        @Override
                        public int compare(Product o1, Product o2) {
                            return Integer.compare(o1.getRating(), o2.getRating());   // Integer is used here, it is the b est practice to use wrapper classes
                        }                                                             //for double use Double.compare(o1.getRating(), o2.getRating())
                    });
                    System.out.println("rating Desc comparator: " + Arrays.toString(product));
                    break;
                case 10:
                    Arrays.sort(product, new Comparator<Product>() {
                        @Override
                        public int compare(Product o1, Product o2) {
                            return o2.getDiscount() - o1.getDiscount();
                        }
                    });
                    System.out.println("discount Desc comparator: " + Arrays.toString(product));
                    break;

            }
            throw new Exception("Invalid number entered!");


        } catch (Exception e) {

            System.out.println("Exception: " + e.getMessage());
        }
    }
    }
