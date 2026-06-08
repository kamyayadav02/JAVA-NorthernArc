package intro;

public class MainDouble {

        public static void main(String[] args){
            double value = 10.5;

            // Boxing
            Double i = Double.valueOf(value);
            System.out.println(i);

            // Autoboxing
            Double j = value;
            System.out.println(j);

            // Unboxing
            double unboxed = i.doubleValue();
            System.out.println(unboxed);
        }
    }

