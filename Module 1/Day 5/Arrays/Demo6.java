package arraysDemo;
import java.util.Arrays;
public class Demo6 {
    public static void main(String[] args) {
        Integer arr[]={10,90,38,39,76};
        System.out.println("Before sorting");
        System.out.println(Arrays.toString(arr));
        Arrays.sort(arr);
        System.out.println("After sorting: ");
        System.out.println(Arrays.toString(arr));
        System.out.println("----------------------------");
        String sarr[]={"Sachin","Saurav","Rahul","Yuvraj","Anil"};
        System.out.println("Before sorting:");
        System.out.println(Arrays.toString(sarr));
        Arrays.sort(sarr);
        System.out.println("After sorting");
        System.out.println(Arrays.toString(sarr));
    }

}
