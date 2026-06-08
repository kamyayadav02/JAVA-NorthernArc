package intro;

public class Main {
    public static void main(String[] args){
        StringBuilder sb= new StringBuilder("Hello");
        //StringBuffer sb= new StringBuffer("Hello");
        System.out.println(sb);
        sb.append("World");
        System.out.println(sb);
        sb.insert(0,"Hi");
        System.out.println(sb);
        sb.delete(0,2);
        System.out.println(sb);
        sb.replace(5,11,"Java");
        System.out.println(sb);
        sb.reverse();
        System.out.println(sb);
    }
}
