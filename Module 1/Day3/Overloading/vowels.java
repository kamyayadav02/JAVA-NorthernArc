package intro;
import java.util.Scanner;

public class vowels {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter a string:");
        String str= sc.nextLine();
        int count=0;
        System.out.println("Vowels in a string");
        for(int i=0;i<str.length();i++){
            char ch= Character.toLowerCase(str.charAt(i));
            if(ch=='a' || ch=='e' || ch == 'i' || ch == 'o' || ch == 'u'){
                System.out.println(ch+"");
                count++;

    }
}
        System.out.println("\nTotal vowels: " + count);
    }
}
