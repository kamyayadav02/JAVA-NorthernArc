package intro;

public class MainFloat {
    public static void main(String[] args){
        float value= 12;
        //boxing
        Float f=value;
        System.out.println(f);
        //unboxing
        float unbox=f.floatValue();
        System.out.println(unbox);
    }
}
