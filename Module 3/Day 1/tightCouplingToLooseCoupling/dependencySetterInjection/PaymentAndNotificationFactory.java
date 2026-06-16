package dependencySetterInjection;

import dependencyDemo_ConstructorInjection.DebitCard;
import dependencyDemo_ConstructorInjection.NotificationService;
import dependencyDemo_ConstructorInjection.PaymentService;
import dependencyDemo_ConstructorInjection.WhatsappNotification;
import dependencyDemo_ConstructorInjection.EmailNotification;

public class PaymentAndNotificationFactory {
    private static CreditCard creditCard=new CreditCard();
    private static DebitCard debitCard=new DebitCard();
    private static UPI upi=new UPI();
    private static WhatsappNotification whatsappNotification=new WhatsappNotification();
    private static EmailNotification emailNotification=new EmailNotification();
    public static PaymentService getPaymentService(int paymentType){

        switch (paymentType) {
            case 1:
                return debitCard;

            case 2:
                return creditCard;

            case 3:
                return upi;

            default:
                throw new IllegalArgumentException("Invalid Payment Type");
        }
    }
    public static NotificationService getNotificationService(String notificationType) {

        if (notificationType == null) {
            throw new IllegalArgumentException("Notification type cannot be null");
        }

        if (notificationType.equalsIgnoreCase("email")) {
            return emailNotification;
        } else if (notificationType.equalsIgnoreCase("whatsapp")) {
            return whatsappNotification;
        }

        throw new IllegalArgumentException("Invalid Notification Type");
    }

}


