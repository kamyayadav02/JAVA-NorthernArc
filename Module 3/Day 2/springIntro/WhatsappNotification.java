package paymentDemo;

public class WhatsappNotification implements NotificationService{
    public void getMessage(String message){
        System.out.println("Received message through whatsapp notification" +message);
    }
}
