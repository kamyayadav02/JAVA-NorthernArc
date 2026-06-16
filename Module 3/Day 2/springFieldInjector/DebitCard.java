package paymentDemo;
import org.springframework.stereotype.Component;
@Component("debit")
public class DebitCard implements PaymentService{
    @Override
    public void pay(double amount) {
        System.out.println("Debit card used for payment of "+ amount);
    }
}
