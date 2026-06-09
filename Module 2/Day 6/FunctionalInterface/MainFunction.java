package functional;

import java.util.function.Function;

public class MainFunction {
    public static void main(String[] args) {
        class Demo implements Function<String,Integer>{

            @Override
            public Integer apply(String s) {
                return s.length();
            }
        }
        Demo d=new Demo();
        System.out.println(d.apply("Hello"));
    }
}
