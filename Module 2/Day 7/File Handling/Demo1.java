package writing;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Demo1 {
    public static void main(String[] args) {
        try (Writer fw = new FileWriter("myfirstfile.txt", true)) {
            fw.write("Hello\n");
            fw.write("Hi\n");
            fw.write("Bye\n");
            System.out.println("Data has been appended to the file.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}