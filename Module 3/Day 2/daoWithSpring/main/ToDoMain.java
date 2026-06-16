package main;

import config.SpringConfiguration;
import dao.ToDoDao;
import dao.ToDoDaoImplCollections;
import entity.ToDo;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class ToDoMain {

    public static void main(String[] args)  {

        Map<Integer, ToDo> todos = new LinkedHashMap<>();

        ApplicationContext context =
                new AnnotationConfigApplicationContext(SpringConfiguration.class);

        ToDoDao toDoDao = context.getBean(ToDoDao.class);

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\nTODO MENU ");
            System.out.println("1. Add Todo");
            System.out.println("2. Delete Todo");
            System.out.println("3. Update Todo");
            System.out.println("4. Find Todo By Id");
            System.out.println("5. Find All Todos");
            System.out.println("6. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter Id: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Content: ");
                    String content = sc.nextLine();

                    ToDo todo = new ToDo(id, content, false);
                    try {
                        toDoDao.save(todo);
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }

                    System.out.println("Todo Added");
                    break;

                case 2:
                    System.out.print("Enter Id to delete: ");
                    int deleteId = sc.nextInt();

                    try {
                        toDoDao.deleteById(deleteId);
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }

                    System.out.println("Todo Deleted");
                    break;

                case 3:
                    System.out.print("Enter Id to update: ");
                    int updateId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter New Content: ");
                    String newContent = sc.nextLine();

                    System.out.print("Completed? (true/false): ");
                    boolean done = sc.nextBoolean();

                    ToDo updatedTodo =
                            new ToDo(updateId, newContent, done);

                    toDoDao.updateById(updateId, updatedTodo);

                    System.out.println("Todo Updated");
                    break;

                case 4:
                    System.out.print("Enter Id: ");
                    int findId = sc.nextInt();

                    System.out.println(toDoDao.findById(findId));
                    break;

                case 5:
                    System.out.println(toDoDao.findAll());
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