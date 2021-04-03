package ru.job4j.io.duplicates;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DuplicatesVisitor extends SimpleFileVisitor<Path> {
    private Set<FileProperty> data = new HashSet<>();
    private List<FileProperty> rsl = new ArrayList<>();

    public List<FileProperty> getFiles() {
        return rsl;
    }

    @Override
    public FileVisitResult visitFile(
            Path file, BasicFileAttributes attrs) throws IOException {
        FileProperty fileProperty = new FileProperty(
                file.toFile().getTotalSpace(), file.toFile().getName());
        if (!data.add(fileProperty)) {
            rsl.add(fileProperty);
        }
        return super.visitFile(file, attrs);
    }
}
