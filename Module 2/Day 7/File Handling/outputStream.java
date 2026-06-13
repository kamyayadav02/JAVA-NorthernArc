package outputStream;

import java.io.FileOutputStream;
import java.io.OutputStream;

public class outputStream {
    public static void main(String[] args) {
        try(OutputStream fos=new FileOutputStream("newoutput.txt");){
            String data="Hello Galaxy";
            fos.write(data.getBytes());
            System.out.println("Data has been written");
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
