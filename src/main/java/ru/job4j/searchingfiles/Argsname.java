package ru.job4j.searchingfiles;

import java.util.HashMap;
import java.util.Map;

public class Argsname {

    private final Map<String, String> values = new HashMap<>();

    public String get(String key) {
        if (values.get(key) == null) {
            throw new IllegalArgumentException("Введены не все аргументы");
        }
        return values.get(key);
    }

    private void parse(String[] args) {
        for (String s
                : args) {
            if (s.contains("=") && !(s.charAt(s.length() - 1) == ('='))) {
                String[] g = s.split("=");
                for (String s1
                        : g) {
                    if (s1.isEmpty()) {
                        throw new IllegalArgumentException();
                    }
                }
                values.put(g[0].replaceAll("-", ""), g[1]);
            } else {
                throw new IllegalArgumentException();
            }
        }
    }

    public static Argsname of(String[] args) {
        Argsname names = new Argsname();
        names.parse(args);
        return names;
    }
}
