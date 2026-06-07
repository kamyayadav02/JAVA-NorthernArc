

import java.util.Scanner;
public class loops{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the starting number");
        int start = sc.nextInt();
        System.out.println("Enter the ending number");
        int ending = sc.nextInt();
        for(int i=start;i<=ending;i++){
            if(i%2==0){
                System.out.println(i);
            }
        }
        sc.close();
 
       
    }
 
}