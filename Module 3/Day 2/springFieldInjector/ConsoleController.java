package paymentDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class ConsoleController {

    private ExpenseManager expenseManager;
    private Scanner sc = new Scanner(System.in);

    @Autowired
    public ConsoleController(ExpenseManager expenseManager) {
        this.expenseManager = expenseManager;
    }

    public void start() {

        while (true) {

            System.out.println("\n PAYMENT MENU");
            System.out.println("1. Pay Electricity Bill");
            System.out.println("2. Pay Water Bill");
            System.out.println("3. Pay Gas Bill");
            System.out.println("4. Exit");

            System.out.print("Enter choice: ");

            int choice;
            try {
                choice = sc.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid input");
                sc.nextLine();
                continue;
            }

            switch (choice) {

                case 1:
                    System.out.print("Enter amount: ");
                    double elecAmount = sc.nextDouble();
                    expenseManager.payElectricityBill(elecAmount);
                    break;

                case 2:
                    System.out.print("Enter amount: ");
                    double waterAmount = sc.nextDouble();
                    expenseManager.payWaterBill(waterAmount);
                    break;

                case 3:
                    System.out.print("Enter amount: ");
                    double gasAmount = sc.nextDouble();
                    expenseManager.payGasBill(gasAmount);
                    break;

                case 4:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
