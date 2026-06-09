package ui;

import dao.ToDoDao;
import dao.ToDoDaoImpl;
import Entity.ToDo;

import java.util.Scanner;

public class MainToDo {

    public static void main(String[] args) {

        ToDoDao dao = new ToDoDaoImpl();

        dao.save(new ToDo(1, "Learn Java", false));
        dao.save(new ToDo(2, "Do Assignment", false));
        dao.save(new ToDo(3, "Exercise", true));

        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n1. Show All Tasks");
            System.out.println("2. Find Task by ID");
            System.out.println("3. Delete Task by ID");
            System.out.println("4. Update Task");
            System.out.println("5. Delete All Tasks");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("\nAll Tasks:");
                    for (ToDo t : dao.findAll()) {
                        System.out.println(t);
                    }
                    break;

                case 2:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    System.out.println(dao.findById(id));
                    break;

                case 3:
                    System.out.print("Enter ID to delete: ");
                    int delId = sc.nextInt();
                    dao.deleteById(delId);
                    System.out.println("Task deleted.");
                    break;

                case 4:
                    System.out.print("Enter ID to update: ");
                    int upId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter new Task: ");
                    String task = sc.nextLine();

                    System.out.print("Is completed? (true/false): ");
                    boolean completed = sc.nextBoolean();

                    dao.update(new ToDo(upId, task, completed));
                    System.out.println("Task updated!");
                    break;

                case 5:
                    dao.deleteAll();
                    System.out.println("All tasks deleted!");
                    break;

                case 6:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice");
            }

        } while (choice != 6);

        sc.close();
    }
}