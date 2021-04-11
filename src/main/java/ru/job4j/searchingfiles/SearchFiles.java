package ru.job4j.searchingfiles;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import static java.nio.file.FileVisitResult.CONTINUE;

public class SearchFiles extends SimpleFileVisitor<Path> {
    private List<Path> path = new ArrayList<>();
    private Predicate<Path> predicate;

    public SearchFiles(Predicate<Path> predicate) {
        this.predicate = predicate;
    }

    public List<Path> getPaths() {
        return path;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        if (predicate.test(file)) {
            path.add(file.toAbsolutePath());
        }
        return super.visitFile(file, attrs);
    }
}
