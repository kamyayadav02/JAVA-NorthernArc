package intro;

public class Main1 {
    public static void main(String[] args){
        String s=new String("Hello");
        String s2="Hello";
        System.out.println(s==s2);
        System.out.println(s.intern()==s2);
        System.out.println(s.equals(s2));

    }
}
