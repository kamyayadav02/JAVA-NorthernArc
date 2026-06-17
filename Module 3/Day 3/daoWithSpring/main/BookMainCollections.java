package main;

import config.SpringConfiguration;
import dao.BookDao;
import entity.Book;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookMainCollections {
    public static void main(String[] args) {
        List<Book> books= new ArrayList<>();
        ApplicationContext context =
                new AnnotationConfigApplicationContext(SpringConfiguration.class);
        BookDao bookDao=context.getBean(BookDao.class);

        Scanner sc=new Scanner(System.in);

        while (true) {

            System.out.println("\nBook MENU ");
            System.out.println("1. Add Book");
            System.out.println("2. Delete Books By Id");
            System.out.println("3. Delete All Books");
            System.out.println("4. Update Book");
            System.out.println("5. Find Book By Id");
            System.out.println("6. Find All Books");
            System.out.println("7. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter Id: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter Author: ");
                    String author = sc.nextLine();
                    System.out.print("Enter Publisher: ");
                    String publisher = sc.nextLine();

                    Book book = new Book(id, title, author,publisher);
                    bookDao.save(book);

                    System.out.println("Book Added");
                    break;

                case 2:
                    System.out.print("Enter Id to delete: ");
                    int deleteId = sc.nextInt();

                    bookDao.deleteById(deleteId);

                    System.out.println("Book Deleted");
                    break;

                case 3:

                    bookDao.deleteAll();
                    System.out.println("All Books Deleted");
                    break;

                case 4:

                    System.out.print("Enter Id to update: ");
                    int updateId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter New Title: ");
                    String newTitle = sc.nextLine();

                    System.out.print("Enter the author : ");
                    String newAuthor = sc.nextLine();

                    System.out.print("Enter the publisher : ");
                    String newPublisher = sc.nextLine();

                    Book updatedBook =
                            new Book(updateId, newTitle, newAuthor, newPublisher);

                    bookDao.updateById(updateId, updatedBook);

                    System.out.println("Book Updated");
                    break;

                case 5:
                    System.out.print("Enter Id: ");
                    int searchId = sc.nextInt();

                    System.out.println(bookDao.findById(searchId));
                    break;

                case 6:
                    System.out.println(bookDao.findAll());
                    break;

                case 7:
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
}


