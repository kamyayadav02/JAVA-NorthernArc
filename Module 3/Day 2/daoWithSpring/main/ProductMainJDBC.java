package main;

import config.SpringConfiguration;
import dao.ProductDao;
import entity.Product;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Collection;
import java.util.Scanner;

public class ProductMainJDBC {

    public static void main(String[] args) {

        ApplicationContext context =
                new AnnotationConfigApplicationContext(SpringConfiguration.class);

        ProductDao productDao =
                context.getBean("productJDBC", ProductDao.class);

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n===== PRODUCT MENU =====");
            System.out.println("1. Add Product");
            System.out.println("2. Delete Product");
            System.out.println("3. Update Product");
            System.out.println("4. Find Product By Id");
            System.out.println("5. Find All Products");
            System.out.println("6. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    sc.nextLine();

                    System.out.print("Enter Product Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Brand: ");
                    String brand = sc.nextLine();

                    System.out.print("Enter Category: ");
                    String category = sc.nextLine();

                    Product newProduct = new Product(name, brand, category);
                    productDao.save(newProduct);

                    System.out.println("Product Added");
                    break;

                case 2:
                    System.out.print("Enter Product Id to delete: ");
                    int deleteId = sc.nextInt();

                    productDao.deleteById(deleteId);
                    System.out.println("Product Deleted");
                    break;

                case 3:
                    System.out.print("Enter Product Id to update: ");
                    int updateId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter New Name: ");
                    String newName = sc.nextLine();

                    System.out.print("Enter New Brand: ");
                    String newBrand = sc.nextLine();

                    System.out.print("Enter New Category: ");
                    String newCategory = sc.nextLine();

                    Product updated = new Product(newName, newBrand, newCategory);
                    productDao.updateById(updateId, updated);

                    System.out.println("Product Updated");
                    break;

                case 4:
                    System.out.print("Enter Product Id: ");
                    int findId = sc.nextInt();

                    Product found = productDao.findById(findId);
                    if (found != null) {
                        System.out.println("Found: " + found);
                    } else {
                        System.out.println("Product Not Found");
                    }
                    break;

                case 5:
                    Collection<Product> products = productDao.findAll();

                    if (products.isEmpty()) {
                        System.out.println("No Products Found");
                    } else {
                        System.out.println("All Products:");
                        products.forEach(System.out::println);
                    }
                    break;

                case 6:
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
}