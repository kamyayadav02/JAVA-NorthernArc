package Multithreading;

import java.io.IOException;
import java.io.Writer;

public class MyThread extends Thread {


        private String name;

        public MyThread(String name) {
            this.name = name;
        }

        // Run method (executed when thread starts)
        @Override
        public void run() {
            for (int i = 1; i < 50; i++) {
                System.out.println(name + i + " - " + Thread.currentThread().getName());
            }
        }
    }


//    private Writer writer;
//
//    public MyThread(String name) {
//        super(name);         // set thread name
//        this.writer = writer;
//    }
//
//    @Override
//    public void run() {
//        for (int i = 1; i < 50; i++) {
//            try {
//                // synchronized block to prevent file corruption
//                synchronized (writer) {
//                    writer.write(i + " " + Thread.currentThread().getName() + "\n");
//                }
//            } catch (IOException e) {
//                System.out.println("Error: " + e.getMessage());
//            }
//        }
//    }
//}
//
