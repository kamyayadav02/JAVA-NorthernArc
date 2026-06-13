package inputStream;

import java.io.FileInputStream;
import java.io.InputStream;

public class inputStream {
    public static void main(String[] args) {
        try(InputStream fis=new FileInputStream("newoutput.txt");){
            int value;
            while((value=fis.read())!=-1){
                System.out.println((char)value);
            }
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
