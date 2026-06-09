package functional;

public class MainLambdaExp {
    public static void main(String[] args) {

        Greeting gm = ()-> {
                System.out.println("Good Morning");
        };
        gm.greet();

        Greeting ga=()-> {
                System.out.println("Good Afternoon");
        };
        ga.greet();

        Greeting ge = ()-> {
                System.out.println("Good Evening");
        };
        ge.greet();

        Greeting gn =()-> {
                System.out.println("Good Night");
        };
        gn.greet();
    }
}
