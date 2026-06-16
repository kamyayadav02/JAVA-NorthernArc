package main;

import config.SpringConfiguration;
import dao.ToDoDao;
import entity.ToDo;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.Map;
import java.util.Scanner;

public class ToDoMainJDBC {

    public static void main(String[] args) throws SQLException {

        ApplicationContext context =
                new AnnotationConfigApplicationContext(SpringConfiguration.class);


        ToDoDao toDoDao = context.getBean("todoJDBC",ToDoDao.class);

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\nTODO MENU");
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
                    sc.nextLine();

                    System.out.print("Enter Content: ");
                    String content = sc.nextLine();

                    ToDo newTodo = new ToDo(0, content, false);
                    toDoDao.save(newTodo);

                    System.out.println("Todo Added");
                    break;

                case 2:
                    System.out.print("Enter Id to delete: ");
                    int deleteId = sc.nextInt();

                    toDoDao.deleteById(deleteId);
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

                    ToDo updatedTodo = new ToDo(updateId, newContent, done);
                    toDoDao.updateById(updateId, updatedTodo);

                    System.out.println("Todo Updated");
                    break;


                case 4:
                    System.out.print("Enter Id: ");
                    int findId = sc.nextInt();

                    ToDo found = toDoDao.findById(findId);
                    if (found != null) {
                        System.out.println(" Found: " + found);
                    } else {
                        System.out.println("Todo not found");
                    }
                    break;


                case 5:
                    Map<Integer, ToDo> todos = toDoDao.findAll();

                    if (todos.isEmpty()) {
                        System.out.println("No Todos Found");
                    } else {
                        System.out.println(" All Todos:");
                        todos.forEach((id, todo) -> System.out.println(todo));
                    }
                    break;


                case 6:
                    System.out.println(" Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println(" Invalid Choice");
            }
        }
    }
}