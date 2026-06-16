package paymentDemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        ApplicationContext context=new AnnotationConfigApplicationContext(MySpringConfiguration.class);

        Scanner sc = new Scanner(System.in);

        System.out.println("Select Payment Method: credit / debit / UPI");
        String paymentChoice = sc.nextLine();

        System.out.println("Select Notification: email / whatsapp");
        String notificationChoice = sc.nextLine();

        PaymentService paymentService = null;
        NotificationService notificationService = null;

        switch (paymentChoice.toLowerCase()) {
            case "credit":
                paymentService = context.getBean("credit", PaymentService.class);
                break;
            case "debit":
                paymentService = context.getBean("debit", PaymentService.class);
                break;
            case "upi":
                paymentService = context.getBean("UPI", PaymentService.class);
                break;
            default:
                System.out.println("Invalid payment option");
                return;
        }

        switch (notificationChoice.toLowerCase()) {
            case "email":
                notificationService = context.getBean("EmailNotification", NotificationService.class);
                break;
            case "whatsapp":
                notificationService = context.getBean("WhatsappNotification", NotificationService.class);
                break;
            default:
                System.out.println("Invalid notification option");
                return;
        }


        ExpenseManager expenseManager =
                new ExpenseManager(paymentService, notificationService);

        expenseManager.payElectricityBill(1000);
        expenseManager.payGasBill(900);
        expenseManager.payWaterBill(400);

        sc.close();




//        PaymentService paymentService1=context.getBean("credit",PaymentService.class);
//        PaymentService paymentService2=context.getBean("debit",PaymentService.class);
//        PaymentService paymentService3=context.getBean("UPI",PaymentService.class);
//        NotificationService notificationService1=context.getBean("EmailNotification",NotificationService.class);
//        NotificationService notificationService2=context.getBean("WhatsappNotification",NotificationService.class);
//        ExpenseManager expenseManager=new ExpenseManager(paymentService,notificationService);
//        expenseManager.payElectricityBill(1000);
//        expenseManager.payGasBill(900);
//        expenseManager.payWaterBill(400);

    }
}
