package ObjectOperations;

public class Main2 {
    public static void main (String[] args){
        Person o1=new Person("Sachin", "Tendulkar",25);
        Person o2=new Person("Sachin", "Tendulkar",25);
        Object o3=o1;
        System.out.println(o1==o2);
        System.out.println(o1==o3);
        System.out.println(o1.equals(o2));
        System.out.println(o1.equals(o3));
        System.out.println(o1.hashCode());
        System.out.println(o2.hashCode());
        System.out.println(o3.hashCode());
        System.out.println(o1.hashCode()==o2.hashCode());
        System.out.println(o1.getClass().getSimpleName());
        System.out.println(o1.getClass().getName());
        System.out.println(o1.toString());
    }
}
