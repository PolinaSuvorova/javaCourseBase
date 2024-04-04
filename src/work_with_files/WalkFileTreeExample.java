package work_with_files;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class WalkFileTreeExample {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("C:\\Users\\ptatara\\Desktop\\new\\X");
        Files.walkFileTree(path,new MyFileVisitor());
    }
}

class MyFileVisitor implements FileVisitor<Path>{

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        System.out.println("Enter to directory: " + dir);
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        System.out.println("Enter to file: " + file.getFileName());
        return  FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        System.out.println("Error in file " + file);
        return  FileVisitResult.TERMINATE;
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        System.out.println("Exit from directory: " + dir);
        return  FileVisitResult.CONTINUE;
    }
}
