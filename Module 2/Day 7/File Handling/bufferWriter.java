package writing;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class bufferWriter {
    public static void main(String[] args) {
        try (Writer fw = new FileWriter("myfirstfile.txt",true);
             BufferedWriter bw=new BufferedWriter(fw);){
            bw.write("Hello");
            bw.newLine();
            bw.write("Hey");
            bw.newLine();
            bw.write("Hi");
            bw.newLine();
            System.out.println("Data has been written to he file");

        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}
