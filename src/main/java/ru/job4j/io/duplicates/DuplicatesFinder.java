package ru.job4j.io.duplicates;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class DuplicatesFinder {
    public static void main(String[] args) throws IOException {
        DuplicatesVisitor visitor = new DuplicatesVisitor();
        Files.walkFileTree(Path.of(args[0]), visitor);
        for (FileProperty file : visitor.getFiles()) {
            System.out.printf("%s : %s%n", file.getName(), file.getSize());
        }
    }
}