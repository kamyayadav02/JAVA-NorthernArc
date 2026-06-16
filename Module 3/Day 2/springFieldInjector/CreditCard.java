package paymentDemo;
import org.springframework.stereotype.Component;
@Component("credit")
public class CreditCard implements PaymentService {
    public void pay(double amount){
        System.out.println("Credit card used for payment of "+ amount);
    }
}
