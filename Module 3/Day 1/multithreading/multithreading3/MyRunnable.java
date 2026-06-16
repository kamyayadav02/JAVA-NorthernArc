package Multithreading3;

public class MyRunnable implements Runnable{
    @Override
    public void run() {   //this is functional interface as there is only one function.
        for(int i=1;i<=100;i++){
            System.out.println(i + " " + Thread.currentThread().getName());
        }
    }
}
