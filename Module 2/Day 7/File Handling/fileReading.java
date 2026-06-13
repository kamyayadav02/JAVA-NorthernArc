package reading;

import java.io.*;

public class fileReading {
    public static void main(String[] args) {
        try (Reader fr = new FileReader("myfirstfile.txt");){
            int value;
            do{
                value=fr.read();
                System.out.print((char)value);
            }while(value!=-1);

        }
        catch (FileNotFoundException e){
            System.out.println("File not Found!!!");
        } catch (IOException e){
            throw new RuntimeException();
        }
    }
}