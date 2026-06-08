import java.util.Scanner;

public class Grade {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter marks:");
        int mark = sc.nextInt();

        if (mark < 0 || mark > 100) {
            System.out.println("Invalid marks");
        } else if (mark < 40) {
            System.out.println("F");
        } else if (mark < 60) {
            System.out.println("C");
        } else if (mark < 80) {
            System.out.println("B");
        } else if (mark < 90) {
            System.out.println("A");
        } else {
            System.out.println("O");
        }

        sc.close();
    }
}
