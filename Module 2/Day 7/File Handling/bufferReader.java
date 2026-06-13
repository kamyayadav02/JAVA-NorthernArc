package reading;

import java.io.*;

public class bufferReader {
    public static void main(String[] args) {
        try (Reader fr = new FileReader("myfirstfile.txt");
            BufferedReader bfr=new BufferedReader(fr);){
            String line;
            do{
                line=bfr.readLine();
                if(line!=null)
                    System.out.println(line);
            }while(line!=null);

        }
        catch (FileNotFoundException e){
            System.out.println("File not Found!!!");
        } catch (IOException e){
            throw new RuntimeException();
        }
    }
    }


