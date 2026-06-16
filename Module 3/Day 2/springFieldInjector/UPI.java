package paymentDemo;
import org.springframework.stereotype.Component;
@Component("UPI")

public class UPI implements PaymentService{
    @Override
    public void pay(double amount) {
        System.out.println("UPI used for payment of "+ amount);
    }
}
