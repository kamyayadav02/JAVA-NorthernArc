package functional;

import java.util.function.*;

public class MainFunctionAnonymous {
    public static void main(String[] args) {


        Function<String, Integer> f = s -> s.length();
        System.out.println("Function: " + f.apply("Hello"));


        BiFunction<Integer, Integer, Integer> bf = (a, b) -> a + b;
        System.out.println("BiFunction: " + bf.apply(5, 3));


        Predicate<String> p = s -> s.length() > 3;
        System.out.println("Predicate: " + p.test("Hi"));
        System.out.println("Predicate: " + p.test("Hello"));


        UnaryOperator<Integer> u = n -> n * n;
        System.out.println("UnaryOperator: " + u.apply(4));


        BinaryOperator<Integer> b = (x, y) -> x * y;
        System.out.println("BinaryOperator: " + b.apply(5, 2));


        Consumer<String> c = s -> System.out.println("Consumer: " + s);
        c.accept("Hello Consumer");


        Supplier<Double> s = () -> Math.random();
        System.out.println("Supplier: " + s.get());
    }
}