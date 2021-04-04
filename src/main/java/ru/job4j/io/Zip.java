package ru.job4j.io;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {

    public void packFiles(List<Path> sources, Path target) {
        try (ZipOutputStream zip = new ZipOutputStream(
                new BufferedOutputStream(new FileOutputStream(target.toString())))) {
            for (Path s
                    : sources) {
                zip.putNextEntry(new ZipEntry(s.toString()));
                try (BufferedInputStream out = new BufferedInputStream(
                        new FileInputStream(s.toString()))) {
                    zip.write(out.readAllBytes());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void packSingleFile(File source, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(
                new BufferedOutputStream(new FileOutputStream(target)))) {
            zip.putNextEntry(new ZipEntry(source.getPath()));
            try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(source))) {
                zip.write(out.readAllBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<Path> searchE(Path root, String condition) throws IOException {
        SearchFiles searcher = new SearchFiles(p -> !p.toFile().getName().endsWith(condition));
        Files.walkFileTree(root, searcher);
        return searcher.getPaths();
    }

    public static void main(String[] args) throws IOException {
        new Zip().packSingleFile(
                new File("c:\\Lexino\\learningjava\\job4j_design\\.unavailable.csv"),
                new File("unavailable.zip")
        );
        ArgsName jvm = ArgsName.of(args);

        new Zip().packFiles(
                Zip.searchE(Path.of(jvm.get("d")), jvm.get("e")),
                Paths.get(jvm.get("o"))
        );
    }
}
