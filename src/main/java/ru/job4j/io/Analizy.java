package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Analizy {
    public void unavailable(String source, String target) {
        boolean nawli = false;
        List<String> list = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(source))) {
            for (String line = in.readLine(); line != null; line = in.readLine()) {
                if (!nawli && line.contains("400")
                        || !nawli && line.contains("500")) {
                    nawli = true;
                    String[] s = line.split(" ");
                    list.add(s[1]);
                } else if (nawli && (line.contains("200") || line.contains("300"))) {
                    String[] s = line.split(" ");
                    list.add(s[1]);
                    nawli = false;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try (PrintWriter out = new PrintWriter(
                new BufferedOutputStream(
                        new FileOutputStream(target)
                ))) {
            for (int i = 0; i < list.size() - 1; i++) {
                out.println(String.format("%s;%s;", list.get(i), list.get(i + 1)));
                i++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Analizy analizy = new Analizy();
        analizy.unavailable("server.log", "unavailable.csv");
    }
}
