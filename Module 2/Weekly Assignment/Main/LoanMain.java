package ui;

import dao.*;
import entity.Loan;

import java.util.Scanner;

public class LoanMain {

    static LoanDao dao = new LoanDaoImpl();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n===== LOAN MENU =====");
            System.out.println("1. Add Loan");
            System.out.println("2. Find Loan by ID");
            System.out.println("3. View All Loans");
            System.out.println("4. Delete Loan");
            System.out.println("5. Update Loan");
            System.out.println("6. Find by Status");
            System.out.println("7. Find by Type");
            System.out.println("0. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    add();
                    break;

                case 2:
                    System.out.println(dao.findById(sc.nextInt()));
                    break;

                case 3 : dao.findAll().forEach(System.out::println);
                break;

                case 4:
                {
                    System.out.print("Enter ID: ");
                    dao.deleteById(sc.nextInt());
                }
                break;

                case 5 :
                    update();
                    break;

                case 6 :
                    findByStatus();
                    break;

                case 7 :
                    findByType();
                    break;

                case 0 :
                    System.out.println("Exiting");

                default:
                    System.out.println("Invalid");
            }

        } while (choice != 0);
    }

    static void add() {
        System.out.print("Type: ");
        String type = sc.nextLine();

        System.out.print("Amount: ");
        int amount = sc.nextInt();

        sc.nextLine();

        System.out.print("Status: ");
        String status = sc.nextLine();

        System.out.print("Interest: ");
        double interest = sc.nextDouble();

        System.out.print("Tenure: ");
        int tenure = sc.nextInt();

        Loan loan = new Loan(type, amount, status, interest, tenure);
        dao.save(loan);
    }

    static void update() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Type: ");
        String type = sc.nextLine();

        System.out.print("Amount: ");
        int amount = sc.nextInt();

        sc.nextLine();

        System.out.print("Status: ");
        String status = sc.nextLine();

        System.out.print("Interest: ");
        double interest = sc.nextDouble();

        System.out.print("Tenure: ");
        int tenure = sc.nextInt();

        Loan loan = new Loan(type, amount, status, interest, tenure);
        dao.updateById(id, loan);
    }

    static void findByStatus() {
        System.out.print("Enter status: ");
        String status = sc.nextLine();
        dao.findByStatus(status).forEach(System.out::println);
    }

    static void findByType() {
        System.out.print("Enter type: ");
        String type = sc.nextLine();
        dao.findByType(type).forEach(System.out::println);
    }
}
