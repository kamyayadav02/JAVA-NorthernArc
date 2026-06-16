package dependencyDemo_ConstructorInjection;

public class ExpenseManager {
    private PaymentService paymentService;

    //constructor injection

    public ExpenseManager(PaymentService paymentService, NotificationService notificationService) {
        this.paymentService = paymentService;
        this.notificationService=notificationService;

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
