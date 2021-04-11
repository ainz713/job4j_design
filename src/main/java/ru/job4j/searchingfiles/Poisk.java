package ru.job4j.searchingfiles;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Poisk {
    public void writeFiles(List<Path> sources, Path target) {
        try (PrintWriter printWriter = new PrintWriter(
                new BufferedOutputStream(
                        new FileOutputStream(target.toString())))) {
            for (Path fileFrom: sources) {
                printWriter.write(fileFrom.toString() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Path> searchM(Path root, String condition) throws IOException {
      SearchFiles searcher = new SearchFiles(p -> p.toFile().getName().endsWith(condition));
        Files.walkFileTree(root, searcher);
        return searcher.getPaths();
    }

    public static List<Path> searchF(Path root, String condition) throws IOException {
        SearchFiles searcher = new SearchFiles(p -> p.toFile().getName().equals(condition));
        Files.walkFileTree(root, searcher);
        return searcher.getPaths();
    }

    public static List<Path> searchR(Path root, String condition) throws IOException {
        Pattern pattern = Pattern.compile(condition);
        Matcher matcher;
        SearchFiles searcher = new SearchFiles(p -> pattern.matcher(p.toFile().getName()).find());
        Files.walkFileTree(root, searcher);
        return searcher.getPaths();
    }

    public static void main(String[] args) throws IOException {
        Argsname jvm = Argsname.of(args);
        if (jvm.get("t").equals("mask")) {
            new Poisk().writeFiles(
                    Poisk.searchM(Path.of(jvm.get("d")), jvm.get("n")),
                    Paths.get(jvm.get("o"))
            );
        } else if (jvm.get("t").equals("name")) {
            new Poisk().writeFiles(
                    Poisk.searchF(Path.of(jvm.get("d")), jvm.get("n")),
                    Paths.get(jvm.get("o"))
            );
        } else if (jvm.get("t").equals("regex")) {
            new Poisk().writeFiles(
                    Poisk.searchR(Path.of(jvm.get("d")), jvm.get("n")),
                    Paths.get(jvm.get("o"))
            );
        }
    }
}
