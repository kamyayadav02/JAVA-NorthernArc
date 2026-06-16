package paymentDemo;

public interface NotificationService {
    default void getMessage(String message){
    }
}
