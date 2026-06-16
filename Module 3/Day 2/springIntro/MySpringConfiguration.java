package paymentDemo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class MySpringConfiguration {
    @Bean(name="credit")
    //@Qualifier("credit")
    public PaymentService paymentService1(){
        return new CreditCard();
    }
    @Bean(name="debit")
    public PaymentService paymentService2(){
        return new DebitCard();
    }
    @Bean(name="UPI")
    public PaymentService paymentService3(){
        return new UPI();
    }

    @Bean(name="EmailNotification")
    public NotificationService notificationService1(){
        return new EmailNotification();
    }
    @Bean(name="WhatsappNotification")
    public NotificationService notificationService2(){
        return new WhatsappNotification();
    }

//    @Bean
//    public ExpenseManager expenseManager(@Qualifier ("upi") PaymentService paymentService,@Qualifier ("email") NotificationService notificationService){
//        return new ExpenseManager(paymentService,notificationService);
//    }

}
