package Multithreading;

import java.io.FileWriter;
import java.io.Writer;
import java.io.IOException;

public class Main2 {
    public static void main(String[] args) {

        try {

            Writer w = new FileWriter("output.txt");

            Thread t1 = new MyThread("Sachin ");
            Thread t2 = new MyThread("Rahul ");



            t1.start();
            t2.start();
            try {


                // t1.join();
                t2.join();
            }catch (InterruptedException e){
                System.out.println("Message: " + e.getMessage());
            }


            System.out.println("Active Threads: " + Thread.activeCount() + "\n");

            for (int i = 1; i < 100; i++) {
                w.write(i + " " + Thread.currentThread().getName() + "\n");
            }


            w.close();


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

