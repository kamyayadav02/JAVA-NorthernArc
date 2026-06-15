package resourceSharing;

import java.io.*;

public class MyThread extends  Thread {
    private static OutputStream destinationwriter;
    private InputStream sourcereader;

    public MyThread(String name,InputStream sourcereader) {
        super(name);
        this.sourcereader = sourcereader;
    }

    public static void openDestinationWriter() {
        try {
            MyThread.destinationwriter = new FileOutputStream("C:\\Users\\kamya.yadav\\Desktop\\practice\\Practicework\\MultiThreading\\src\\Output.log");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void closeDestinationWriter() {
        try {
            destinationwriter.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void run() {
        synchronized (destinationwriter) {
            System.out.println("Thread name: " + Thread.currentThread().getName());
            int c;
            try {
                while ((c = sourcereader.read()) != -1) {
                    destinationwriter.write(c);
                }

            } catch (IOException e) {
                throw new RuntimeException(e);
            } finally {
                try {
                    sourcereader.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}

