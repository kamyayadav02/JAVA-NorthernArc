package Multithreading;

public class Main {
    public static void main(String[] args){
        try { // we have to use try catch since we are using join
            Thread t1 = new MyThread("Sachin ");
            Thread t2 = new MyThread("Rahul ");
            t1.start();
            t2.start();
            //Thread Joining
            t1.join();
            t2.join();
        }catch(InterruptedException e){
            System.out.println("");
        }
        System.out.println("Active Threads: " +Thread.activeCount());
        for(int i=1;i<100;i++) {
            System.out.println(i+" " + Thread.currentThread().getName());
        }
    }
}
