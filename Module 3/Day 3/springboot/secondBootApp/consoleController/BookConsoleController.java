package com.northernArc.secondbootapp.consoleController;

import com.northernArc.secondbootapp.Dao.BookDao;
import com.northernArc.secondbootapp.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.Scanner;

@Component
public class BookConsoleController {
    @Autowired
    private Scanner scanner;

    @Autowired
    private BookDao bookDao;

    public void printWelcomeMessage(){
        System.out.println("Welcome to Todo Dao service..");
    }
    public void showMenu() throws SQLException {
        while(true){
            System.out.println("1. Add");
            System.out.println("2. Update");
            System.out.println("3. Delete");
            System.out.println("4. List All");
            System.out.println("5. Find By id");
            int choice = scanner.nextInt();
            redirectChoice(choice);
        }

    }
    private void redirectChoice(int choice) throws SQLException{
        switch (choice){
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
                listAll();
                break;
            case 5:
                findById();
                break;
            default:
                System.out.println("Invalid choice");
        }
    }
    private void listAll() {
        System.out.println(bookDao.findAll());
    }
    private void delete() throws SQLException {
        System.out.println("Enter id of book to be deleted:");
        int id=scanner.nextInt();
        bookDao.deleteById(id);
    }
    private void update() {
        System.out.println("Enter id of book to be updated:");
        int id=scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter new title:");
        String title=scanner.nextLine();
        System.out.println("Enter new author:");
        String author =scanner.nextLine();
        System.out.println("Enter new publisher:");
        String publisher =scanner.nextLine();
        bookDao.updateById(id,new Book(title,author,publisher));
    }
    private void add(){
        System.out.println("Enter id:");
        int id=scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter new title:");
        String title=scanner.nextLine();
        System.out.println("Enter new author:");
        String author =scanner.nextLine();
        System.out.println("Enter new publisher:");
        String publisher =scanner.nextLine();
        bookDao.save(new Book(id,title,author,publisher));
    }

    private void findById() {
        System.out.println("Enter id of book to find:");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println(bookDao.findById(id));
    }

}
