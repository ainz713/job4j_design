package ru.job4j.jdbc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Argsapp {
    private final Map<String, String> values = new HashMap<>();

    public String get(String key) {
        if (values.get(key) == null) {
            throw new IllegalArgumentException("Имеются не все аргументы");
        }
        return values.get(key);
    }

    private void parse(String file) {
        List<String> list = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(file))) {
            for (String line = in.readLine(); line != null; line = in.readLine()) {
                list.add(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (String s
                : list) {
            if (s.contains("=")) {
                String[] g = s.split("=");
                for (String s1
                        : g) {
                    if (s1.isEmpty()) {
                        throw new IllegalArgumentException();
                    }
                }
                values.put(g[0], g[1]);
            } else {
                throw new IllegalArgumentException();
            }
        }
    }

    public static Argsapp of(String file) {
        Argsapp names = new Argsapp();
        names.parse(file);
        return names;
    }
}
