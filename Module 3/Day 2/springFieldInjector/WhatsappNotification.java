package paymentDemo;
import org.springframework.stereotype.Component;
@Component("whatsapp")
public class WhatsappNotification implements NotificationService{
    public void getMessage(String message){
        System.out.println("Received message through whatsapp notification" +message);
    }
}
