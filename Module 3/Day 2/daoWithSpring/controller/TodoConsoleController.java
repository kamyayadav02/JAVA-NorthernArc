package controller;
import dao.ToDoDao;
import entity.ToDo;

import java.sql.SQLException;
import java.util.Scanner;
public class TodoConsoleController {
    private Scanner scanner;
    private ToDoDao todoDao;
    public TodoConsoleController(Scanner scanner, ToDoDao todoDao){
        this.scanner=scanner;
        this.todoDao=todoDao;
    }
    public void printWelcomeMessage(){
        System.out.println("Welcome to Todo Dao service..");
    }
    public void showMenu() throws SQLException {
        while(true) {
            System.out.println("1:Add");
            System.out.println("2:Update");
            System.out.println("3:Delete");
            System.out.println("4:List All");
            System.out.println("Enter your choice:");
            int choice = scanner.nextInt();
            redirectChoice(choice);
        }
    }
    private void redirectChoice(int choice) throws SQLException {
        switch(choice){
            case 1:
                add();
                break;
            case 2:
                update();
                break;
            case 3:
                delete();
            case 4:
                listAll();
                break;
            default:
                System.out.println("Invalid choice");
        }
    }
    private void listAll() {
        System.out.println(todoDao.findAll());
    }
    private void delete() throws SQLException {
        System.out.println("Enter id of task to be deleted:");
        int id=scanner.nextInt();
        todoDao.deleteById(id);
    }
    private void update() {
        System.out.println("Enter id of task to be updated:");
        int id=scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter new content:");
        String content=scanner.nextLine();
        System.out.println("Enter new done status:");
        boolean done=scanner.nextBoolean();
        todoDao.updateById(id,new ToDo(content,done));
    }
    private void add() throws SQLException {
        System.out.println("Enter id:");
        int id=scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter content:");
        String content=scanner.nextLine();
        System.out.println("Enter done:");
        boolean done=scanner.nextBoolean();
        todoDao.save(new ToDo(id,content,done));
    }
}
