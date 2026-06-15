package Multithreading2;

public class Main {
    public static void main(String[] args) {

        MyThread t1 = new MyThread("Sachin", 100);
        MyThread t2 = new MyThread("Sourav", 400);
        MyThread t3 = new MyThread("Rahul", 800);


        t3.setDaemon(true);


        t1.start();
        t2.start();
        t3.start();


        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        }

        System.out.println("Main threads finished");
    }
}