package demo;
import java.util.Scanner;
public class customException {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter username");
        String username= sc.next();
        System.out.println("Enter password");
        String password=sc.next();
        try{
            if(username!="kamya" && password!= "kamya123"){
                throw new InvalidCredentials("Invalid credentials");
            }
            System.out.println("Successful");

            }
        catch(InvalidCredentials e){
            System.out.println("");
        }
    }
}

