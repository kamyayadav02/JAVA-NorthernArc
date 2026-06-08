package intro;
import java.util.Scanner;

public class space {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string");
        String str = sc.nextLine();
        int count = 0;
        System.out.println("Spaces in a string");
        for (int i = 0; i < str.length(); i++) {
            char ch = Character.toLowerCase(str.charAt(i));
            if (ch == ' ') {
                System.out.println(ch + "");
                count++;
            }
        }
        System.out.println("\nTotal spaces: " + count);

    }
}
