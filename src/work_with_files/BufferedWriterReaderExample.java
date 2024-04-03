package work_with_files;

import java.io.*;

public class BufferedWriterReaderExample {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(
                new FileReader("test2.txt"));
             BufferedWriter writer = new BufferedWriter(
                     new FileWriter("test3.txt", true))) {
            // Чтение и запись посимвольная
            int character;
            while ((character = reader.read()) != -1) {
                writer.write(character);
            }
            writer.close();
            // Чтение и запись построчная
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
            }
            System.out.println("Done");
        }
    }
}
