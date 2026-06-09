package functional;

public class MainAnonymous {

        public static void main(String[] args) {

            Greeting gm = new Greeting() {
                @Override
                public void greet() {
                    System.out.println("Good Morning");
                }
            };
            gm.greet();

            Greeting ga=new Greeting() {
                @Override
                public void greet() {
                    System.out.println("Good Afternoon");
                }
            };
            ga.greet();

            Greeting ge = new Greeting() {
                @Override
                public void greet() {
                    System.out.println("Good Evening");
                }
            };
            ge.greet();

            Greeting gn = new Greeting() {
                @Override
                public void greet() {
                    System.out.println("Good Night");
                }
            };
            gn.greet();
        }
    }

