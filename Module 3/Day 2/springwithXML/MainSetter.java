package service;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

public class MainSetter {
    public static void main(String[] args) {

        ApplicationContext context =
                new ClassPathXmlApplicationContext("ApplicationContextSetter.xml");

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Payment Method (credit/debit/upi):");
        String payment = sc.nextLine();

        System.out.println("Enter Notification Method (email/whatsapp):");
        String notification = sc.nextLine();

        ExpenseManagerSetter expenseManager = null;

        switch (payment.toLowerCase()) {

            case "credit":
                switch (notification.toLowerCase()) {
                    case "email":
                        expenseManager = context.getBean("expenseManager1",
                                ExpenseManagerSetter.class);
                        break;
                    case "whatsapp":
                        expenseManager = context.getBean("expenseManager2",
                                ExpenseManagerSetter.class);
                        break;
                }
                break;

            case "debit":
                switch (notification.toLowerCase()) {
                    case "email":
                        expenseManager = context.getBean("expenseManager3",
                                ExpenseManagerSetter.class);
                        break;
                    case "whatsapp":
                        expenseManager = context.getBean("expenseManager4",
                                ExpenseManagerSetter.class);
                        break;
                }
                break;

            case "upi":
                switch (notification.toLowerCase()) {
                    case "email":
                        expenseManager = context.getBean("expenseManager5",
                                ExpenseManagerSetter.class);
                        break;
                    case "whatsapp":
                        expenseManager = context.getBean("expenseManager6",
                                ExpenseManagerSetter.class);
                        break;
                }
                break;

            default:
                System.out.println("Invalid Payment Method");
                return;
        }

        if (expenseManager == null) {
            System.out.println("Invalid Notification Method");
            return;
        }

        expenseManager.payElectricityBill(1000);
        expenseManager.payGasBill(900);
        expenseManager.payWaterBill(400);

        sc.close();
    }
}
