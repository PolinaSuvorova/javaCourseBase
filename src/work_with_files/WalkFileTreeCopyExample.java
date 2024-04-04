package work_with_files;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class WalkFileTreeCopyExample {
    public static void main(String[] args) throws IOException {
        Path source = Paths.get("C:\\Users\\ptatara\\Desktop\\new");
        Path destination = Paths.get("C:\\Users\\ptatara\\Desktop\\copyNew");
        Files.walkFileTree(source, new MyFileVisitor2(source,destination));
    }
}

class MyFileVisitor2 extends SimpleFileVisitor<Path> {
    private final Path source;
    private final Path destination;

    public MyFileVisitor2(Path source, Path destination) {
        this.source = source;
        this.destination = destination;
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        Path newDestination = destination.resolve(source.relativize(dir));
        if (!Files.exists(newDestination)) {
            Files.copy(dir, newDestination);
        }
        return super.preVisitDirectory(dir, attrs);
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        Path newFile = destination.resolve(source.relativize(file));
        if (!Files.exists(newFile)) {
            Files.copy(file, newFile, StandardCopyOption.REPLACE_EXISTING);
        }
        return super.visitFile(file, attrs);
    }
}
