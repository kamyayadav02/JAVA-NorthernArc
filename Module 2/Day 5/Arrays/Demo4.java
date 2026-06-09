package arraysDemo;

public class Demo4 {
    public static void main(String[] args) {
        int arr2[]={10,20,30,40,50};  //you can directly give the values and then change if want or you can directly give values
        System.out.println(arr2[0]);
        System.out.println(arr2[1]);
        System.out.println(arr2[2]);
        System.out.println(arr2[3]);
        System.out.println(arr2[4]);
        System.out.println("_________________________");
        System.out.println(arr2.length);
        arr2[0]=100;
//        for(int i=0;i<arr2.length;i++){
//            System.out.println(arr2[i]);
//        }
        System.out.println("__________________________-");
        //iterative for loop
        for (int value:arr2){
            System.out.println(value);

        }
    }
}
