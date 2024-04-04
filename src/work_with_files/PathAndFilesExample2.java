package work_with_files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class PathAndFilesExample2 {
    public static void main(String[] args) throws IOException {
        Path filePath = Paths.get("test15.txt");
        Path directoryPath = Paths.get("C:\\Users\\ptatara\\Desktop\\new\\X");
        Path directoryPath2 = Paths.get("C:\\Users\\ptatara\\Desktop\\new\\B");
        // test15.txt скопируется с тем же именем в путь directoryPath
        System.out.println(directoryPath.resolve(filePath));
        Files.copy(filePath, directoryPath.resolve(filePath), StandardCopyOption.REPLACE_EXISTING);
        Files.copy(filePath, directoryPath.resolve("test16.txt"), StandardCopyOption.REPLACE_EXISTING);
        // Копирует директорию без файлов
        Files.copy(directoryPath2,directoryPath.resolve("B"),StandardCopyOption.REPLACE_EXISTING);

        // Через move можем как перемещать из папки в папку, так и переименовывать
        Files.move(filePath,Paths.get("test15_2.txt"));
        // Если удаляем папки то они должны быть пустыми
        Files.delete(Paths.get("test15_2.txt"));

    }
}
