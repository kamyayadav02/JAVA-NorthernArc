package intro;

public class MainLong {
    public static void main(String[] args){
        long value=10;
        Long l=Long.valueOf(value);
        System.out.println(l);

        //autoboxing
        Long m=value;
        System.out.println(m);

        //unboxing

        long unboxed=l.intValue();
        System.out.println(unboxed);
    }
}
