import java.util.Scanner;
public class paymentMain {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter a choice: 1:upi , 2: debitcard, 3: creditcard");
        int choice=sc.nextInt();
        Payment pay;
        switch(choice){
            case 1:
                pay= new upi();
                break;
            case 2:
                pay= new debit();
                break;
            case 3:
                pay= new credit();
                break;
            default:
                System.out.println("Invalid Choice");
                sc.close();
                return;
        }
        pay.makePayment(15000);
        sc.close();

    }


    
}
