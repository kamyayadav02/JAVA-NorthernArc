package paymentDemo;

public class EmailNotification implements NotificationService{
    public void getMessage(String message){
        System.out.println("Received message through email notification" +message);
    }
}
