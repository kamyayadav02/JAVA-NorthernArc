package Assignment;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        BankAccount account = new BankAccount();

        System.out.print("Enter Account Owner Name: ");
        account.setAccountOwner(sc.nextLine());

        System.out.print("Enter Initial Balance: ");
        account.setBalance(sc.nextDouble());

        while (true) {
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            if (choice == 1) {
                System.out.print("Enter amount: ");
                double amt = sc.nextDouble();
                account.deposit(amt);

            } else if (choice == 2) {
                System.out.print("Enter amount: ");
                double amt = sc.nextDouble();
                account.withdraw(amt);

            } else if (choice == 3) {
                account.checkBalance();

            } else if (choice == 4) {
                System.out.println("Exiting...");
                break;

            } else {
                System.out.println("Invalid choice");
            }
        }
        sc.close();
    }
}