package ru.job4j.searchingfiles;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Predicate;
import java.util.regex.Pattern;

public class Poisk {
    public static void writeFiles(List<Path> sources, Path target) {
        try (PrintWriter printWriter = new PrintWriter(
                new BufferedOutputStream(
                        new FileOutputStream(target.toString())))) {
            for (Path fileFrom: sources) {
                printWriter.println(fileFrom.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Predicate<Path> searchCondition(Argsname args) {
        if (args.get("t").equals("mask")) {
            return p -> p.toFile().getName().endsWith(args.get("n"));
        } else if (args.get("t").equals("name")) {
            return p -> p.toFile().getName().equals(args.get("n"));
        } else if (args.get("t").equals("regex")) {
            Pattern pattern = Pattern.compile(args.get("n"));
            return p -> pattern.matcher(p.toFile().getName()).find();
        }
        return null;
    }

    public static List<Path> search(Path root, Argsname args) throws IOException {
        SearchFiles searcher = new SearchFiles(Poisk.searchCondition(args));
        Files.walkFileTree(root, searcher);
        return searcher.getPaths();
    }

    public static void main(String[] args) throws IOException {
        Argsname jvm = Argsname.of(args);
        Poisk.writeFiles(Poisk.search(Path.of(jvm.get("d")), jvm),
                Paths.get(jvm.get("o")));
    }
}
