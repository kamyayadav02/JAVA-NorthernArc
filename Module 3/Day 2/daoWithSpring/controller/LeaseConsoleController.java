package controller;

import dao.LeaseDao;
import entity.LeaseAgreement;

import java.util.Scanner;

public class LeaseConsoleController {

    private Scanner sc;
    private LeaseDao dao;

    public LeaseConsoleController(Scanner sc, LeaseDao dao) {
        this.sc = sc;
        this.dao = dao;
    }

    public void showMenu() {

        while (true) {

            System.out.println("\n1:Add Lease");
            System.out.println("2:Update Lease");
            System.out.println("3:Delete Lease");
            System.out.println("4:Find Lease");
            System.out.println("5:List All");
            System.out.println("6:Exit");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Id:");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Asset:");
                    String asset = sc.nextLine();

                    System.out.print("Customer:");
                    String customer = sc.nextLine();

                    System.out.print("Amount:");
                    double amount = sc.nextDouble();

                    System.out.print("Duration:");
                    int duration = sc.nextInt();

                    System.out.print("Active:");
                    boolean active = sc.nextBoolean();

                    dao.save(new LeaseAgreement(id, asset, customer, amount, duration, active));
                    break;

                case 5:
                    dao.findAll().forEach((k,v) -> System.out.println(v));
                    break;

                case 6:
                    return;
            }
        }
    }
}
