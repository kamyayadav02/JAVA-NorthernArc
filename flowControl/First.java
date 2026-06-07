
public class First {

    // function to find greatest of 3 numbers
    public static void checkNumber(int num) {
        if (num>0) {
            System.out.println("number is positive");
        } else if (num<0) {
            System.out.println("number is negative");
        } else {
            System.out.println("number is zero");
        }
    }
    public static void main(String[] args) {
        checkNumber(10);
        checkNumber(0);

    }
}