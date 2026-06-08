package demo;
import java.util.Scanner;
public class ManuallyThrow {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter your name");
        String name=sc.next();
        try {
            if (!name.equals("Sachin") && !name.equals("Rahul") && !name.equals("Sourav")) {
                throw new NameNotFound("Invalid name");
            }
            System.out.println("Welcome to the party " + name);
        } catch (NameNotFound e) {
            System.out.println("You are not allowed " + e.getMessage());
        }
            }
    }

