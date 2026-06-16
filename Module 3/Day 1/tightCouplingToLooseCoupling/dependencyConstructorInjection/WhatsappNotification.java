package dependencyDemo_ConstructorInjection;

public class WhatsappNotification implements NotificationService{
    @Override
    public void message(String message) {
        System.out.println("Received message through whatsapp notification");
    }
}
