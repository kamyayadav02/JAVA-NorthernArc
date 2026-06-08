import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter choice:");
        System.out.println("1. Lion");
        System.out.println("2. Dog");
        System.out.println("3. Deer");

        int choice = sc.nextInt();



        if (choice == 1) {
            a = new Lion("Simba", "Wild", 5);
        } else if (choice == 2) {
            a = new Dog("Tommy", "Pet", 3);
        } else if (choice==3){
            a= new Deer("Charlie","Domestic", 8);
        } else {
            System.out.println("Invalid choice");
            return;
        }

        a.getDetails();
        a.eat();
        a.walk();
        a.talk();

        sc.close();
    }
}
