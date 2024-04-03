package work_with_files;

import java.io.FileWriter;
import java.io.IOException;

// Класс пишет и читает данные посимвольно, обращаясь каждый раз к файлу
public class FileWriterExample {
    public static void main(String[] args) throws IOException {
        String rubai = "Test test test test test test test test teeeeeeest";
        String str2 = "Hello";

        try (FileWriter writer = new FileWriter("test2.txt", true);) {
            writer.write(rubai);
            writer.write(str2);
//            for (int i = 0; i < rubai.length(); i++) {
//                writer.write(rubai.charAt(i));
//            }
            System.out.println("Done");
        } catch (IOException e) {
            e.printStackTrace();
//        } finally {
//          writer.close();// закрываем стрим, инае ничего не сохраниться
//        }
        }
    }
}