package dependencyDemo_ConstructorInjection;

public class CreditCard implements PaymentService{

    @Override
    public void pay(double amount) {
        System.out.println("Credit card used for payment of "+ amount);
    }
}
