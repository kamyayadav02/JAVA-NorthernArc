package paymentDemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "paymentDemo")
public class Main {

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(Main.class);

        ConsoleController controller = context.getBean(ConsoleController.class);
        controller.start();
    }
}

//        PaymentService paymentService1=context.getBean("credit",PaymentService.class);
//        PaymentService paymentService2=context.getBean("debit",PaymentService.class);
//        PaymentService paymentService3=context.getBean("UPI",PaymentService.class);
//        NotificationService notificationService1=context.getBean("EmailNotification",NotificationService.class);
//        NotificationService notificationService2=context.getBean("WhatsappNotification",NotificationService.class);
//        ExpenseManager expenseManager=new ExpenseManager(paymentService,notificationService);
//        expenseManager.payElectricityBill(1000);
//        expenseManager.payGasBill(900);
//        expenseManager.payWaterBill(400);

