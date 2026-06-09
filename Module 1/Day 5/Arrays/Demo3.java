package arraysDemo;

public class Demo3 {
    public static void main(String[] args) {
        char arr1[]=new char[5];
        arr1[0]='h';
        arr1[1]='e';
        arr1[2]='l';
        arr1[3]='l';
        arr1[4]='o';
        System.out.println("Length of array: " + arr1.length);
        for(int i=0;i<arr1.length;i++){
            System.out.println(arr1[i]);
        }

    }
}
