package main;

import dao.LeaseDao;
import dao.LeaseDaoImplCollections;
import entity.LeaseAgreement;

import java.util.Map;
import java.util.Scanner;

public class LeaseMainCollections {

    public static void main(String[] args) {

        LeaseDao dao = new LeaseDaoImplCollections();
        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n===== LEASE MENU =====");
            System.out.println("1. Add Lease");
            System.out.println("2. Delete Lease");
            System.out.println("3. Update Lease");
            System.out.println("4. Find Lease By Id");
            System.out.println("5. Find All Leases");
            System.out.println("6. Exit");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter Id: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Asset: ");
                    String asset = sc.nextLine();

                    System.out.print("Customer: ");
                    String customer = sc.nextLine();

                    System.out.print("Amount: ");
                    double amount = sc.nextDouble();

                    System.out.print("Duration: ");
                    int duration = sc.nextInt();

                    System.out.print("Active: ");
                    boolean active = sc.nextBoolean();

                    dao.save(new LeaseAgreement(id, asset, customer, amount, duration, active));
                    break;

                case 5:
                    Map<Integer, LeaseAgreement> list = dao.findAll();
                    list.forEach((k, v) -> System.out.println(v));
                    break;

                case 6:
                    return;
            }
        }
    }
}