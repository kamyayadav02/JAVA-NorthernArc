package service;

public class ExpenseManagerSetter {
    private PaymentService paymentService;
    private NotificationService notificationService;

    public PaymentService getPaymentService() {
        return paymentService;
    }

    public void setPaymentService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public NotificationService getNotificationService() {
        return notificationService;
    }

    public void setNotificationService(NotificationService notificationService) {
        this.notificationService = notificationService;
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
