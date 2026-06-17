package controller;

import dao.CreditScoreDao;
import entity.CreditScore;

import java.util.Scanner;

public class CreditScoreConsoleController {
    private Scanner scanner;
    private CreditScoreDao creditScoreDao;

    public CreditScoreConsoleController(Scanner scanner, CreditScoreDao creditScoreDao) {
        this.scanner = scanner;
        this.creditScoreDao = creditScoreDao;
    }

    public void printWelcomeMessage() {
        System.out.println("Welcome to CreditScore Dao service..");
    }
    public void showMenu() {
        while(true){
            System.out.println("\nCredit Score Menu");
            System.out.println("1. Add Credit Score");
            System.out.println("2. Delete Credit Score By Customer Id");
            System.out.println("3. Delete All Credit Scores");
            System.out.println("4. Update Credit Score");
            System.out.println("5. Find Credit Score By Customer Id");
            System.out.println("6. Find All Credit Scores");
            System.out.println("7. Exit");
            int choice = scanner.nextInt();
            redirectChoice(choice);

        }
    }

    private void redirectChoice(int choice)  {
        switch (choice) {
            case 1:
                add();
                break;
            case 2:
                deleteById();
                break;
            case 3:
                deleteAll();
                break;
            case 4:
                update();
                break;
            case 5:
                findById();
                break;
            case 6:
                listAll();
                break;
            case 7:
                System.out.println("Exiting...");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice");
        }
    }


    private void add() {
        try {
            System.out.println("Enter id:");
            int id = scanner.nextInt();

            System.out.println("Enter score:");
            int score = scanner.nextInt();

            creditScoreDao.save(new CreditScore(id, score));
            System.out.println("Credit Score Details added successfully");

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }





    private void update(){
        System.out.println("Enter id of credit to be updated:");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter new score:");
        int score = scanner.nextInt();

        creditScoreDao.updateById(id, new CreditScore(score));
        System.out.println("Credit score updated!");
    }
    private void deleteById(){
        System.out.println("Enter id of Credit to be deleted.");
        int id= scanner.nextInt();
        creditScoreDao.deleteById(id);
        System.out.println("Credit deleted.");
    }

    private void deleteAll(){
        System.out.print("Are you sure you want to delete ALL credits? (yes/no): ");
        String confirm = scanner.next();

        if (confirm.equalsIgnoreCase("yes")) {
            creditScoreDao.deleteAll();
            System.out.println("All credits deleted!");
        } else {
            System.out.println("Operation cancelled.");
        }
    }

    public void findById(){
        System.out.println("Enter id: ");
        int id= scanner.nextInt();
        CreditScore creditScore=creditScoreDao.findById(id);
        System.out.println(creditScore);
    }
     public void listAll(){
         System.out.println(creditScoreDao.findAll());
     }




}
