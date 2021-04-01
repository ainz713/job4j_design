package ru.job4j.io;

import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class AnalizyTest {

    @Test
    public void analysisServerLog() throws IOException {
        String source = ".server.log";
        String target = ".unavailable.csv";
        try (PrintWriter out = new PrintWriter(source)) {
            out.println("200 10:56:01");
            out.println("500 10:57:01");
            out.println("400 10:58:01");
            out.println("200 10:59:01");
            out.println("500 11:01:02");
            out.println("200 12:02:02");
        }
        Analizy analysis = new Analizy();
        analysis.unavailable(source, target);
        StringBuilder rsl = new StringBuilder();
        List<String> list1 = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(target))) {
            for (String line = reader.readLine(); line != null; line = reader.readLine()) {
                list1.add(line);
            }
        }
        assertThat(list1.get(0), is("10:57:01;10:58:01;"));
        assertThat(list1.get(1), is("11:01:02;12:02:02;"));
    }
}