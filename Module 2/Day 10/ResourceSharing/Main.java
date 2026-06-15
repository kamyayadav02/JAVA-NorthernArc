package resourceSharing;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {
        try{
            Thread t1=new MyThread("Sachin",new FileInputStream("C:\\Users\\kamya.yadav\\Desktop\\practice\\Practicework\\MultiThreading\\src\\Sachin.txt"));
            Thread t2=new MyThread("Saurav",new FileInputStream("C:\\Users\\kamya.yadav\\Desktop\\practice\\Practicework\\MultiThreading\\src\\Saurav.txt"));
            MyThread.openDestinationWriter();
            t1.start();
            t2.start();
            t1.join();
            t2.join();
            MyThread.closeDestinationWriter();
            System.out.println("Exiting Main Thread.");
        }catch (FileNotFoundException e){
            throw new RuntimeException(e);
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }

    }
}
