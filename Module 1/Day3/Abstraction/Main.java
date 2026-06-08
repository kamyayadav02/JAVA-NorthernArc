import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter choice of animal: 1:Lion, 2:Dog, 3:Deer");
            int choice=sc.nextInt();
            switch(choice){
                case 1:

            Animal animal=new lion();
            animal.eat();
            animal.talk();
            animal.shelter();
            break;
            case 2:
            Animal animal2=new dog();
            animal2.eat();
            animal2.talk();
            animal2.shelter();
            break;
            case 3:
            Animal animal3=new deer();
            animal3.eat();
            animal3.talk();
            animal3.shelter();
            break;
            default:
                System.out.println("Invalid Choice");
            }
        }


    }
    
}
