package work_with_files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

// Объект типа Path представляет собой путь файлу или директории
public class PathAndFilesExample {
    public static void main(String[] args) throws IOException {
        Path filePath = Paths.get("test15.txt");
        Path directoryPath = Paths.get("C:\\Users\\ptatara\\Desktop\\new\\X");

        System.out.println("filePath.getFileName()" + filePath.getFileName());
        System.out.println("directoryPath.getFileName()" + directoryPath.getFileName());
        System.out.println("------------------------");
        System.out.println("filePath.getParent()" + filePath.getParent());
        System.out.println("directoryPath.getParent()" + directoryPath.getParent());
        System.out.println("------------------------");
        System.out.println("filePath.getRoot()" + filePath.getRoot());
        System.out.println("directoryPath.getRoot()" + directoryPath.getRoot());
        System.out.println("------------------------");
        System.out.println("filePath.isAbsolute()" + filePath.isAbsolute());
        System.out.println("directoryPath.isAbsolute()" + directoryPath.isAbsolute());
        System.out.println("------------------------");
        System.out.println("filePath.toAbsolutePath()" + filePath.toAbsolutePath());
        System.out.println("directoryPath.toAbsolutePath()" + directoryPath.toAbsolutePath());
        System.out.println("------------------------");
        System.out.println("filePath.toAbsolutePath().getParent " + filePath.toAbsolutePath().getParent());
        System.out.println("directoryPath.toAbsolutePath().getParent " + directoryPath.toAbsolutePath().getParent());
        System.out.println("------------------------");

        System.out.println("directoryPath.resolve(filePath) " + directoryPath.resolve(filePath));
        System.out.println("------------------------");

        Path anotherPath = Paths.get("C:\\Users\\ptatara\\Desktop\\new\\X\\Z\\test20.txt");
        System.out.println("directoryPath.relativize(anotherPath) " + directoryPath.relativize(anotherPath));
        System.out.println("------------------------");

        if( !Files.exists(filePath) ){
            System.out.println(Files.createFile(filePath));
        }

        if( !Files.exists(directoryPath)){
            Files.createDirectory(directoryPath);
        }

        System.out.println(Files.isReadable(filePath));
        System.out.println(Files.isWritable(filePath));
        System.out.println(Files.isExecutable(filePath));

        System.out.println(Files.readAttributes(filePath, "*"));

    }
}
