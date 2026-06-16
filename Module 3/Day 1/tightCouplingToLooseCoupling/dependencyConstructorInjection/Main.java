package dependencyDemo_ConstructorInjection;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Payment method:\n 1: Debit card\n 2: Credit Card\n 3: UPI");
        int paymentType = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter notification type (email/whatsapp):");
        String notificationType = sc.nextLine();

        PaymentService paymentService = PaymentAndNotificationFactory.getPaymentService(paymentType);

        NotificationService notificationService = PaymentAndNotificationFactory.getNotificationService(notificationType);

        ExpenseManager expenseManager = new ExpenseManager(paymentService, notificationService);

        expenseManager.payElectricityBill(1000);
        expenseManager.payWaterBill(200);
        expenseManager.payGasBill(100);

        sc.close();
    }
}