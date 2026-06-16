package controller;

import dao.ProductDao;
import entity.Product;

import java.util.Scanner;

public class ProductConsoleController {

    private Scanner scanner;
    private ProductDao productDao;

    public ProductConsoleController(Scanner scanner, ProductDao productDao) {
        this.scanner = scanner;
        this.productDao = productDao;
    }

    public void printWelcomeMessage() {
        System.out.println("Welcome to Product Dao service..");
    }

    public void showMenu() {
        while (true) {
            System.out.println("1: Add");
            System.out.println("2: Update");
            System.out.println("3: Delete");
            System.out.println("4: Find By Id");
            System.out.println("5: List All");
            System.out.println("Enter your choice:");

            int choice = scanner.nextInt();
            redirectChoice(choice);
        }
    }

    private void redirectChoice(int choice) {
        switch (choice) {
            case 1:
                add();
                break;
            case 2:
                update();
                break;
            case 3:
                delete();
                break;
            case 4:
                findById();
                break;
            case 5:
                listAll();
                break;
            default:
                System.out.println("Invalid choice");
        }
    }

    private void listAll() {
        System.out.println(productDao.findAll());
    }

    private void delete() {
        System.out.println("Enter product id to be deleted:");
        int id = scanner.nextInt();
        productDao.deleteById(id);
    }

    private void findById() {
        System.out.println("Enter product id:");
        int id = scanner.nextInt();
        Product product = productDao.findById(id);

        if (product != null) {
            System.out.println(product);
        } else {
            System.out.println("Product not found");
        }
    }

    private void update() {
        System.out.println("Enter product id to be updated:");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter new name:");
        String name = scanner.nextLine();

        System.out.println("Enter new brand:");
        String brand = scanner.nextLine();

        System.out.println("Enter new category:");
        String category = scanner.nextLine();

        productDao.updateById(id, new Product(name, brand, category));
    }

    private void add() {
        System.out.println("Enter product id:");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter name:");
        String name = scanner.nextLine();

        System.out.println("Enter brand:");
        String brand = scanner.nextLine();

        System.out.println("Enter category:");
        String category = scanner.nextLine();

        productDao.save(new Product(id, name, brand, category));
    }
}