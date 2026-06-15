package Multithreading;

import java.io.IOException;
import java.io.Writer;

public class MyThread extends Thread {

    private Writer w;   // add writer


    public MyThread(String name) {
        super(name);   // keeps thread name
        this.w = w;
    }

    public void run() {
        try {
            for (int i = 1; i <= 100; i++) {   // also fixed &lt;
                w.write(i + " " + this.getName() + "\n");
            }
        } catch (IOException e) {
            System.out.println("Error writing to file");
        }
    }
}