package arraysDemo;
import java.util.Scanner;

public class Demo5 {
    public static void main(String[] args) {

        String arr3[] = new String[3];
        arr3[0] = "Sachin";
        arr3[1] = "Sourav";
        arr3[2] = "Sparsh";

        System.out.println("Length of array " + arr3.length);

        for (String value : arr3) {
            System.out.println(value);
        }

        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("Enter a name: ");
            String name = sc.next();

            if (name.equalsIgnoreCase("Sachin")) {
                System.out.println("Welcome " + arr3[0]);
            } else if (name.equalsIgnoreCase("Sourav")) {
                System.out.println("Welcome " + arr3[1]);
            } else if (name.equalsIgnoreCase("Sparsh")) {
                System.out.println("Welcome " + arr3[2]);
            } else {
                throw new Exception("Invalid name entered!");
            }

        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }

        String temp = arr3[0];
        arr3[0] = arr3[1];
        arr3[1] = temp;
        System.out.println("Swapping names:");

        for (String value : arr3) {
            System.out.println(value);
        }
        String rev = "";

        for (int i = arr3.length - 1; i >= 0; i--) {
            rev = rev + arr3[i] + " ";
        }

        System.out.println("The reverse array is: " + rev);

        sc.close();
    }
}
