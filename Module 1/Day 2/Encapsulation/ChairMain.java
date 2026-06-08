package Encapsulation;

public class ChairMain {
    public static void main(String[] args) {
        Chair chair=new Chair("wood", "brown", 15);
        chair.adjustHeight();
        chair.getDetails();
    }
}
