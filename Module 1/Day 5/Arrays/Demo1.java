package arraysDemo;

import java.util.Arrays;

//arrays are collection of values of similar data type stored in contiguous memory
public class Demo1 {
    public static void main(String[] args) {
        int arr[]=new int[5];
        arr[0]=10;
        arr[1]=20;
        arr[2]=30;
        arr[3]=40;
        arr[4]=50;
        System.out.println("Length of array: " +arr.length);
        for(int i=0;i< arr.length;i++){
            System.out.println(arr[i]);
        }
        for(int value:arr){
            System.out.println(value);
        }
        System.out.println(Arrays.toString(arr));
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
