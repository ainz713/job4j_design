package ru.job4j.io;

import java.util.HashMap;
import java.util.Map;

public class ArgsName {

    private final Map<String, String> values = new HashMap<>();

    public String get(String key) {
        if (values.get(key) == null) {
            throw new IllegalArgumentException();
        }
        return values.get(key);
    }

    private void parse(String[] args) {
        /* TODO parse args to values. */
        for (String s
                : args) {
            if (s.contains("=") && !(s.charAt(s.length() - 1) == ('='))) {
                String[] g = s.split("=");
                for (String s1
                        : g) {
                    if (s1.equals(" ")) {
                      throw new IllegalArgumentException();
                    }
                }
                values.put(g[0].replaceAll("-", ""), g[1]);
            } else {
                throw new IllegalArgumentException();
            }
        }
    }

    public static ArgsName of(String[] args) {
        ArgsName names = new ArgsName();
        names.parse(args);
        return names;
    }

    public static void main(String[] args) {
        ArgsName jvm = ArgsName.of(new String[] {"-Xmx=512", "-encoding=UTF-8"});
        System.out.println(jvm.get("Xmx"));

        ArgsName zip = ArgsName.of(new String[] {"-out=project.zip", "-encoding=UTF-8"});
        System.out.println(zip.get("out"));
    }
}
