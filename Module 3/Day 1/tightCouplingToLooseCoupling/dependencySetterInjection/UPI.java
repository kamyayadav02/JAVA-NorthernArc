package dependencySetterInjection;

import dependencyDemo_ConstructorInjection.PaymentService;

public class UPI implements PaymentService {

    @Override
    public void pay(double amount) {
        System.out.println("UPI used for payment of "+ amount);
    }
}
