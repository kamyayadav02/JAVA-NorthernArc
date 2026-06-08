package demo;

import java.io.FileNotFoundException;

public class MainExceptionDemo {
    public static void main (String[] args){
        demo();
    }
    private static void demo() throws FileNotFoundException {
        throw new FileNotFoundException("Division by zero");

    }
}
