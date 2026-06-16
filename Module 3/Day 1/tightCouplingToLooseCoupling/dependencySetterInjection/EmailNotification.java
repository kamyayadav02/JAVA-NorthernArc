package dependencySetterInjection;

public class EmailNotification implements NotificationService{
    @Override
    public void message(String message) {
        System.out.println("Received message through email notification");
    }
}
