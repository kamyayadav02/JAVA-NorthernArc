package ui;

import dao.BookDao;
import dao.BookDaoImpl;
import entity.Book;

import java.util.Scanner;

public class BookMain {

    private static BookDao bookDao = new BookDaoImpl();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n------ MENU ------");
            System.out.println("1. Add Book");
            System.out.println("2. Find Book by ID");
            System.out.println("3. Get All Books");
            System.out.println("4. Delete Book by ID");
            System.out.println("5. Update Book by ID");
            System.out.println("6. Delete All Books");
            System.out.println("7. Find by Author");
            System.out.println("8. Find by Title");
            System.out.println("9. Find by Publisher");
            System.out.println("10. Sort by Title ASC");
            System.out.println("11. Sort by Title DESC");
            System.out.println("12. Find by Title AND Publisher");
            System.out.println("13. Exit");

            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    addBook();
                    break;

                case 2:
                    System.out.println(getBookById());
                    break;

                case 3:
                    getAll();
                    break;

                case 4:
                    deleteById();
                    break;

                case 5:
                    updateBook();
                    break;

                case 6:
                    deleteAll();
                    break;

                case 7:
                    findByAuthor();
                    break;

                case 8:
                    findByTitle();
                    break;

                case 9:
                    findByPublisher();
                    break;

                case 10:
                    bookDao.findSortedByTitleAsc().forEach(System.out::println);
                    break;

                case 11:
                    bookDao.findSortedByTitleDesc().forEach(System.out::println);
                    break;

                case 12:
                    findByTitleAndPublisher();
                    break;

                case 13:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private static void addBook() {
        System.out.print("Enter title: ");
        String title = sc.nextLine();

        System.out.print("Enter author: ");
        String author = sc.nextLine();

        System.out.print("Enter publisher: ");
        String publisher = sc.nextLine();

        Book book = new Book(title, author, publisher);
        int rows = bookDao.save(book);

        System.out.println(rows > 0 ? "Book added successfully!" : "Failed to add book");
    }

    private static Book getBookById() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        return bookDao.findById(id);
    }

    private static void getAll() {
        bookDao.findAll().forEach(System.out::println);
    }

    private static void deleteById() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        bookDao.deleteById(id);
        System.out.println("Deleted successfully.");
    }

    private static void updateBook() {
        System.out.print("Enter ID to update: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter new title: ");
        String title = sc.nextLine();

        System.out.print("Enter new author: ");
        String author = sc.nextLine();

        System.out.print("Enter new publisher: ");
        String publisher = sc.nextLine();

        Book book = new Book(title, author, publisher);
        bookDao.updateById(id, book);

        System.out.println("Updated successfully.");
    }

    private static void deleteAll() {
        bookDao.deleteAll();
        System.out.println("All books deleted.");
    }

    private static void findByAuthor() {
        System.out.print("Enter author: ");
        String author = sc.nextLine();
        bookDao.findByAuthor(author).forEach(System.out::println);
    }

    private static void findByTitle() {
        System.out.print("Enter title: ");
        String title = sc.nextLine();
        bookDao.findByTitle(title).forEach(System.out::println);
    }

    private static void findByPublisher() {
        System.out.print("Enter publisher: ");
        String publisher = sc.nextLine();
        bookDao.findByPublisher(publisher).forEach(System.out::println);
    }

    private static void findByTitleAndPublisher() {
        System.out.print("Enter title: ");
        String title = sc.nextLine();

        System.out.print("Enter publisher: ");
        String publisher = sc.nextLine();

        bookDao.findByTitleAndPublisher(title, publisher)
                .forEach(System.out::println);
    }
}

//        // System.out.println("Enter book details:\n"); for
//        System.out.println("Enter id: ");
//        int id = sc.nextInt();
//        System.out.println(get(id));
//
//    static int
//        Book book=new Book(sc.nextLine(),sc.nextLine(),sc.nextLine());
//        int result=bookDao.save(book);
//        System.out.println(result);
//    }
//}
