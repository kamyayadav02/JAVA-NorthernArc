package service;

public class UPI implements PaymentService{
    @Override
    public void pay(double amount) {
        System.out.println("UPI used for payment of "+ amount);

    }
}
