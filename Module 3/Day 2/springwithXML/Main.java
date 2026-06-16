package service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ApplicationContext context =
                new ClassPathXmlApplicationContext("ApplicationContext.xml");

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Payment Method (credit/debit/upi):");
        String payment = sc.nextLine();

        System.out.println("Enter Notification Method (email/whatsapp):");
        String notification = sc.nextLine();

        ExpenseManager expenseManager = null;

        switch (payment.toLowerCase()) {

            case "credit":
                switch (notification.toLowerCase()) {
                    case "email":
                        expenseManager = context.getBean("expenseManager1",
                                ExpenseManager.class);
                        break;

                    case "whatsapp":
                        expenseManager = context.getBean("expenseManager2",
                                ExpenseManager.class);
                        break;

                    default:
                        System.out.println("Invalid notification method");
                        return;
                }
                break;

            case "debit":
                switch (notification.toLowerCase()) {
                    case "email":
                        expenseManager = context.getBean("expenseManager3",
                                ExpenseManager.class);
                        break;

                    case "whatsapp":
                        expenseManager = context.getBean("expenseManager4",
                                ExpenseManager.class);
                        break;

                    default:
                        System.out.println("Invalid notification method");
                        return;
                }
                break;

            case "upi":
                switch (notification.toLowerCase()) {
                    case "email":
                        expenseManager = context.getBean("expenseManager5",
                                ExpenseManager.class);
                        break;

                    case "whatsapp":
                        expenseManager = context.getBean("expenseManager6",
                                ExpenseManager.class);
                        break;

                    default:
                        System.out.println("Invalid notification method");
                        return;
                }
                break;

            default:
                System.out.println("Invalid payment method");
                return;
        }

        expenseManager.payElectricityBill(1000);
        expenseManager.payGasBill(900);
        expenseManager.payWaterBill(400);

        sc.close();
    }
}
