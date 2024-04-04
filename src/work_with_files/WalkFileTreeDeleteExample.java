package work_with_files;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class WalkFileTreeDeleteExample {
    public static void main(String[] args) throws IOException {
        Path destination = Paths.get("C:\\Users\\ptatara\\Desktop\\copyNew");
        Files.walkFileTree(destination,new MyFileVisitor3());
    }
}
class MyFileVisitor3 extends SimpleFileVisitor<Path> {
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        Files.deleteIfExists(file);
        return super.visitFile(file, attrs);
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        Files.deleteIfExists(dir);
        return super.postVisitDirectory(dir, exc);
    }
}
