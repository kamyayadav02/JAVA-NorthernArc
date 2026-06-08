import java.util.Scanner;
public class MessageMain{
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter a choice: 1:whatsapp , 2: Text, 3: Email");
        int choice=sc.nextInt();
        SimpleMessage sm;
        switch(choice){
            case 1:
                sm= new Whatsapp();
                break;
            case 2:
                sm= new Text();
                break;
            case 3:
                sm= new Email();
                break;
            default:
                System.out.println("Invalid Choice");
                sc.close();
                return;
        }
        sm.sendMessage("Hello");
        sc.close();

    }
}