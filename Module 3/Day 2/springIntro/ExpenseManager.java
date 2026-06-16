package paymentDemo;

public class ExpenseManager {
    private PaymentService paymentService;
    private NotificationService notificationService;


    public ExpenseManager(PaymentService paymentService, NotificationService notificationService) {
        this.paymentService = paymentService;
        this.notificationService=notificationService;
    }

    public void payElectricityBill(double amount){
        System.out.println("Paying electricity bill of "+amount);
        paymentService.pay(amount);
        notificationService.getMessage(
                "Electricity bill of " + amount + " paid successfully\n");
        System.out.println("Electricity bill paid");
    }
    public void payWaterBill(double amount){
        System.out.println("Paying water bill of "+ amount);
        paymentService.pay(amount);
        notificationService.getMessage(
                "Water bill of " + amount + " paid successfully\n");
        System.out.println("Water bill paid");
    }
    public void payGasBill(double amount){
        System.out.println("Paying gas bill of "+ amount);
        paymentService.pay(amount);
        notificationService.getMessage(
                "Gas bill of " + amount + " paid successfully\n");
        System.out.println("Gas bill paid");
    }

}
