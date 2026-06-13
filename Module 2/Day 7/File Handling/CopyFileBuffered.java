package copy;

import java.io.*;

public class CopyFileBuffered {
    public static void main(String[] args) {
        try (
                BufferedReader br = new BufferedReader(new FileReader("src/copy/source.txt"));
                BufferedWriter bw = new BufferedWriter(new FileWriter("src/copy/destination.txt"))
        ) {
            String line;

            while ((line = br.readLine()) != null) {
                bw.write(line);
                bw.newLine();
            }

            System.out.println("File copied successfully!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
