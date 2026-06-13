package LoanDao;

import entity.Book;
import entity.Loan;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookMainstream {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        BookDao dao = new BookDaoImpl();
        dao.save(new Book(101, "James ", "Java Programming"));
        dao.save(new Book(102, "Dennis ", "C Programming"));
        dao.save(new Book(103, " William Shakespeare", "Hamlet"));
        dao.save(new Book(104, "Jk Rowling", "Harry Potter"));
        dao.save(new Book(105, "Anne Frank", "Diary of Anne Frank "));
        System.out.println("Filter by:");
        System.out.println("1. Author");
        System.out.println("2. Title");
        int choice = sc.nextInt();
        sc.nextLine();

        List<Book> result = new ArrayList<>();
        switch (choice) {

            case 1:
                System.out.print("Enter Author: ");
                String author = sc.nextLine();

                result = ((List<Book>) dao.findAll()).stream()
                        .filter(book -> book.getAuthor().equalsIgnoreCase(author))
                        .toList();
                break;

            case 2:
                System.out.print("Enter Title: ");
                String title = sc.nextLine();

                result = ((List<Book>) dao.findAll()).stream()
                        .filter(book -> book.getTitle().equalsIgnoreCase(title))
                        .toList();
                break;

            default:
                System.out.println("Invalid choice");
        }

        System.out.println("here :");
        System.out.println(result);
    }
}
