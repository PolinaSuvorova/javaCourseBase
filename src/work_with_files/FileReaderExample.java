package work_with_files;

import java.io.FileReader;
import java.io.IOException;

// Класс пишет и читает данные посимвольно, обращаясь каждый раз к файлу
public class FileReaderExample {
    public static void main(String[] args) throws IOException {
        try (FileReader reader = new FileReader("test2.txt")) { // автоматом делается close
            int character;
            while ((character = reader.read()) != -1) {
                System.out.println((char) character);
            }
            System.out.println("Done");
        }
    }
}
