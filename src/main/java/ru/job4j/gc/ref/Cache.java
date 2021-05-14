package ru.job4j.gc.ref;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

public class Cache {
    private final Map<String, SoftReference<String>> cache;

    public Cache() {
        this.cache = new HashMap<>();
    }

    private String readFile(String fileName) throws IOException {
        String rsl = "";
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            StringBuilder sp = new StringBuilder();
            for (String line = reader.readLine(); line != null; line = reader.readLine()) {
                    sp.append(line).append(System.lineSeparator());
            }
            rsl = sp.toString();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return rsl;
    }

    public String get(String key) throws IOException {
        String rsl;
        if (cache.containsKey(key)) {
            rsl = cache.get(key).get();
        } else {
            rsl = readFile(key);
            cache.put(key, new SoftReference<>(rsl));
        }
        return rsl;
    }

    public static void main(String[] args) throws IOException {
        Cache cache = new Cache();
        String file1 = "gc.txt";
        System.out.println(cache.get(file1));
        String file2 = "gc1.txt";
        System.out.println(cache.get(file2));
    }
}
