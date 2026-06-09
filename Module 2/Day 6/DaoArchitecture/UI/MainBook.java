package ui;

import dao.BookDao;
import dao.BookDaoImpl;
import Entity.Book;

import java.util.Scanner;

public class MainBook {
    public static void main(String[] args) {

        BookDao dao = new BookDaoImpl();


        dao.save(new Book(101, "James ", "Java Programming"));
        dao.save(new Book(102, "Dennis ", "C Programming"));
        dao.save(new Book(103, " William Shakespeare", "Hamlet"));
        dao.save(new Book(104, "Jk Rowling", "Harry Potter"));
        dao.save(new Book(105, "Anne Frank", "Diary of Anne Frank "));

        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("1. Show All Books");
            System.out.println("2. Find Book by ID");
            System.out.println("3. Delete Book by ID");
            System.out.println("4. Update Book");
            System.out.println("5. Delete All");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("\nAll Books:");
                    for (Book b : dao.findAll()) {
                        System.out.println(b);
                    }
                    break;

                case 2:
                    System.out.print("Enter ID to search: ");
                    int searchId = sc.nextInt();
                    System.out.println(dao.findById(searchId));
                    break;

                case 3:
                    System.out.print("Enter ID to delete: ");
                    int delId = sc.nextInt();
                    dao.deleteById(delId);
                    System.out.println("Book deleted (if existed)");
                    break;

                case 4:
                    System.out.print("Enter ID to update: ");
                    int upId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter new Author: ");
                    String author = sc.nextLine();

                    System.out.print("Enter new Title: ");
                    String title = sc.nextLine();

                    dao.update(new Book(upId, author, title));
                    System.out.println(" Book updated!");
                    break;

                case 5:
                    dao.deleteAll();
                    System.out.println(" All books deleted!");
                    break;

                case 6:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println(" Invalid choice");
            }

        } while (choice != 6);

        sc.close();
    }
}