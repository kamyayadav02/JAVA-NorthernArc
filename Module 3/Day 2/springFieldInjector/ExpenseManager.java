package paymentDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class ExpenseManager {
    @Autowired
    @Qualifier("credit")
    private PaymentService paymentService;

    @Autowired
    @Qualifier("email")
    private NotificationService notificationService;


    public void payElectricityBill(double amount) {
        System.out.println("Paying electricity bill of " + amount);
        paymentService.pay(amount);
        notificationService.getMessage("Electricity bill of " + amount + " paid successfully");
        System.out.println("Electricity bill paid");
    }

    public void payWaterBill(double amount) {
        System.out.println("Paying water bill of " + amount);
        paymentService.pay(amount);
        notificationService.getMessage("Water bill of " + amount + " paid successfully");
        System.out.println("Water bill paid");
    }

    public void payGasBill(double amount) {
        System.out.println("Paying gas bill of " + amount);
        paymentService.pay(amount);
        notificationService.getMessage("Gas bill of " + amount + " paid successfully");
        System.out.println("Gas bill paid");
    }
}
