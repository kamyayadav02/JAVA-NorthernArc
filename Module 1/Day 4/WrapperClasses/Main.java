package intro;

public class Main {
    public static void main(String[] args){
        int value=10;
        Integer i= Integer.valueOf(value); //boxing
        System.out.println(i);
        //autoboxing
        Integer j=value;
        System.out.println(j);
        int unboxed=i.intValue();   //unboxing
        System.out.println(unboxed);

    }
}
