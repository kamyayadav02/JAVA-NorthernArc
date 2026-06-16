package dependencySetterInjection;

import dependencyDemo_ConstructorInjection.ExpenseManager;
import dependencyDemo_ConstructorInjection.NotificationService;
import dependencyDemo_ConstructorInjection.PaymentAndNotificationFactory;
import dependencyDemo_ConstructorInjection.PaymentService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Payment Method: \n 1:Credit Card\n 2:Debit Card\n  3: UPI");
        int paymentType = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter notification type (email/whatsapp):");
        String notificationType = sc.nextLine();
        PaymentService paymentService = dependencyDemo_ConstructorInjection.PaymentAndNotificationFactory.getPaymentService(paymentType);

        NotificationService notificationService = PaymentAndNotificationFactory.getNotificationService(notificationType);

        dependencyDemo_ConstructorInjection.ExpenseManager expenseManager = new ExpenseManager(paymentService, notificationService);

        expenseManager.payElectricityBill(1000);
        expenseManager.payWaterBill(200);
        expenseManager.payGasBill(100);

        sc.close();
    }
}
