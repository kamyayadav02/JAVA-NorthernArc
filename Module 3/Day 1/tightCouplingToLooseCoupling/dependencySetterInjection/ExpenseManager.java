package dependencySetterInjection;

import dependencyDemo_ConstructorInjection.PaymentService;

public class ExpenseManager {
    private PaymentService paymentService;

    public PaymentService getPaymentService() {
        return paymentService;
    }

    public void setPaymentService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public void payElectricityBill(double amount){
        System.out.println("Paying electricity bill of "+amount);
        paymentService.pay(amount);
        System.out.println("Electricity bill paid");
    }
    public void payWaterBill(double amount){
        System.out.println("Paying water bill of "+ amount);
        paymentService.pay(amount);
        System.out.println("Water bill paid");
    }
    public void payGasBill(double amount){
        System.out.println("Paying gas bill of "+ amount);
        paymentService.pay(amount);
        System.out.println("Gas bill paid");
    }
}
