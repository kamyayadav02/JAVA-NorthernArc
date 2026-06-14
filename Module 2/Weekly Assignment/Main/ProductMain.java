package ui;

import dao.ProductDao;
import dao.ProductDaoImpl;
import entity.Book;
import entity.Product;

import java.util.Collection;
import java.util.Scanner;

public class ProductMain {

    static ProductDao productDao = new ProductDaoImpl();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n===== PRODUCT MENU =====");
            System.out.println("1. Add Product");
            System.out.println("2. Find Product by ID");
            System.out.println("3. View All Products");
            System.out.println("4. Delete Product by ID");
            System.out.println("5. Update Product");
            System.out.println("6. Delete All Products");
            System.out.println("7. Find by Name");
            System.out.println("8. Find by Brand");
            System.out.println("9. Find by Category");
            System.out.println("10. Sort by Brand (ASC)");
            System.out.println("11. Sort by Category (ASC)");
            System.out.println("12. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    addProduct();
                    break;

                case 2:
                    Product p = getProductById();
                    System.out.println(p != null ? p : "Product not found");
                    break;

                case 3:
                    getAllProducts();
                    break;

                case 4:
                    deleteProductById();
                    break;

                case 5:
                    updateProduct();
                    break;

                case 6:
                    deleteAllProducts();
                    break;

                case 7:
                    findByName();
                    break;

                case 8:
                    findByBrand();
                    break;

                case 9:
                    findByCategory();
                    break;

                case 10:
                    sortByBrand();
                    break;

                case 11:
                    sortByCategory();
                    break;

                case 12:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice");
            }

        } while (choice != 12);
    }

        public static void addProduct () {
            System.out.print("Enter name: ");
            String name = sc.nextLine();

            System.out.print("Enter brand: ");
            String brand = sc.nextLine();

            System.out.print("Enter category: ");
            String category = sc.nextLine();

            Product product = new Product(name, brand, category);
            int rows = productDao.save(product);

            System.out.println(rows > 0 ? "Product added successfully!" : "Failed to add product");
        }
        private static Product getProductById () {
            System.out.print("Enter ID: ");
            int id = sc.nextInt();
            return productDao.findById(id);
        }
        private static void getAllProducts () {
            productDao.findAll().forEach(System.out::println);
        }
        private static void deleteProductById () {
            System.out.print("Enter ID: ");
            int id = sc.nextInt();
            productDao.deleteById(id);
            System.out.println("Deleted successfully.");
        }
        private static void updateProduct () {
            System.out.print("Enter ID to update: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter new name: ");
            String name = sc.nextLine();

            System.out.print("Enter new brand: ");
            String brand = sc.nextLine();

            System.out.print("Enter new category: ");
            String category = sc.nextLine();

            Product product = new Product(name, brand, category);
            productDao.updateById(id, product);

            System.out.println("Updated successfully.");
        }
        private static void deleteAllProducts () {
            productDao.deleteAll();
            System.out.println("All products deleted.");
        }
        private static void findByName () {
            System.out.print("Enter name: ");
            String name = sc.nextLine();
            productDao.findByName(name).forEach(System.out::println);
        }
        private static void findByBrand () {
            System.out.print("Enter brand: ");
            String brand = sc.nextLine();
            productDao.findByBrand(brand).forEach(System.out::println);
        }
        private static void findByCategory () {
            System.out.print("Enter category: ");
            String category = sc.nextLine();
            productDao.findByCategory(category).forEach(System.out::println);
        }
        private static void sortByBrand () {
            productDao.findSortedByBrandAsc().forEach(System.out::println);
        }

        private static void sortByCategory () {
            productDao.findSortedByCategoryAsc().forEach(System.out::println);
        }
    }





























