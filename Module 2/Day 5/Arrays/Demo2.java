package arraysDemo;

import java.util.Arrays;

public class Demo2 {
    public static void main(String[] args) {
        String arr[]=new String[5];
       // Arrays.fill(arr,"bye");
        arr[0]="lion";
        arr[1]="dog";
        arr[2]="cat";
        arr[3]="deer";
        arr[4]="horse";
        System.out.println("Length of array: " + arr.length);
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }
}
