package work_with_files;

import java.io.*;

public class WorkWithBinaryFileExample {
    public static void main(String[] args) throws IOException {
        try(
                BufferedInputStream  inputStream = new BufferedInputStream(
                        new FileInputStream("image.JPG"));
                BufferedOutputStream outputStream = new BufferedOutputStream(
                        new FileOutputStream("image2.JPG"))){
            int i;
            while ((i=inputStream.read()) != -1){
                outputStream.write(i);
            }
            System.out.println("Done");
        }
    }
}
