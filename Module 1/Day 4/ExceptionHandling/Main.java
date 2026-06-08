package demo;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("enter a");
            int n = sc.nextInt();
            System.out.println("b");
            int m = sc.nextInt();
            double result = n / m;
            System.out.println("Result is:" + result);
            String s=null;
            System.out.println(s.length());
        }
        catch (ArithmeticException e) {
            System.out.println("Division by zero not allowed");
        }
        catch (InputMismatchException e){
            System.out.println("Please enter valid number");
        }
        catch(Exception e){
            System.out.println("Something went wrong" +e);
        } finally {
            System.out.println("This is finally block,it will execute whether exception is there or not");
            sc.close();
        }
        //task2
        System.out.println("Hello world");
    }
}
