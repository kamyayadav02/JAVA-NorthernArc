package functional;

public class Main {
    public static void main(String[] args) {
        class GM implements Greeting{
            @Override
            public void greet(){
                System.out.println("Good Morning");
            }
        }
        Greeting gm=new GM();
        gm.greet();

        class GE implements Greeting{
            @Override
            public void greet(){
                System.out.println("Good Evening");
            }
        }
        Greeting ge=new GE();
        ge.greet();

        class GN implements Greeting{
            @Override
            public void greet(){
                System.out.println("Good Night");
            }
        }
        Greeting gn=new GN();
        gn.greet();

    }
}
