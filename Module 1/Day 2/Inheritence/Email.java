public class Email extends SimpleMessage{
    @Override
    public void sendMessage(String message){
        System.out.println("Email message is sent " + message);
    }
    
}
