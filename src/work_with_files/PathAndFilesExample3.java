package work_with_files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathAndFilesExample3 {
    public static void main(String[] args) throws IOException {
        Path filePath = Paths.get("test_10.txt");
        if (!Files.exists(filePath)){
            Files.createFile(filePath);
            String dialog = "-Privet\n-Privet\n-Kak dela?";
            Files.write(filePath,dialog.getBytes());
        }
        System.out.println(Files.readAllLines(filePath));
    }
}
