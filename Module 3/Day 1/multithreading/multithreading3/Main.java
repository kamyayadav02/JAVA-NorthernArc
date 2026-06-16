package Multithreading3;

public class Main {
    public static void main(String[] args) {

        Thread t1=new Thread(new MyRunnable());
        Thread t2=new Thread(new MyRunnable());
        Thread t3=new Thread(new MyRunnable());
        t1.start();
        t2.start();
        t3.start();
        System.out.println("Exiting main Thread");

    }
}
