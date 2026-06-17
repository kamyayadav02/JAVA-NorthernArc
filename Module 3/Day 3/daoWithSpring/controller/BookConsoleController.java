package controller;

import dao.BookDao;
import entity.Book;

import java.sql.SQLException;
import java.util.Scanner;

public class BookConsoleController {

    private Scanner scanner;
    private BookDao bookDao;


    public BookConsoleController(Scanner scanner, BookDao bookDao) {
        this.scanner = scanner;
        this.bookDao = bookDao;
    }

    public void printWelcomeMessage() {
        System.out.println("Welcome to Book Dao service..");
    }


    public void showMenu() throws SQLException {
        while (true) {
            System.out.println("\nBook MENU ");
            System.out.println("1. Add Book");
            System.out.println("2. Delete Book By Id");
            System.out.println("3. Delete All Books");
            System.out.println("4. Update Book");
            System.out.println("5. Find Book By Id");
            System.out.println("6. Find All Books");
            System.out.println("7. Exit");

            int choice = scanner.nextInt();
            redirectChoice(choice);
        }
    }


    private void redirectChoice(int choice) throws SQLException {
        switch (choice) {
            case 1:
                add();
                break;
            case 2:
                deleteById();
                break;
            case 3:
                deleteAll();
                break;
            case 4:
                update();
                break;
            case 5:
                findById();
                break;
            case 6:
                listAll();
                break;
            case 7:
                System.out.println("Exiting...");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice");
        }
    }


    private void add() throws SQLException {
        System.out.println("Enter id:");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter title:");
        String title = scanner.nextLine();

        System.out.println("Enter author:");
        String author = scanner.nextLine();

        System.out.println("Enter publisher:");
        String publisher = scanner.nextLine();

        bookDao.save(new Book(id, title, author, publisher));
        System.out.println("Book added successfully!");
    }

    private void update() {
        System.out.println("Enter id of book to be updated:");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter new title:");
        String title = scanner.nextLine();

        System.out.println("Enter new author:");
        String author = scanner.nextLine();

        System.out.println("Enter new publisher:");
        String publisher = scanner.nextLine();

        bookDao.updateById(id, new Book(title, author, publisher));
        System.out.println("Book updated!");
    }


    private void deleteById() throws SQLException {
        System.out.println("Enter id of book to be deleted:");
        int id = scanner.nextInt();

        bookDao.deleteById(id);
        System.out.println("Book deleted!");
    }


    private void deleteAll() {
        System.out.print("Are you sure you want to delete ALL books? (yes/no): ");
        String confirm = scanner.next();

        if (confirm.equalsIgnoreCase("yes")) {
            bookDao.deleteAll();
            System.out.println("All books deleted!");
        } else {
            System.out.println("Operation cancelled.");
        }
    }

    private void findById() {
        System.out.println("Enter id:");
        int id = scanner.nextInt();

        Book book = bookDao.findById(id);
        System.out.println(book);
    }


    private void listAll() {
        System.out.println(bookDao.findAll());
    }
}