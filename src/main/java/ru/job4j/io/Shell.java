package ru.job4j.io;

public class Shell {
    private String p = "";

    public void cd(String path) {
        if (path.contains("..")) {
            p = String.format("/%s", path.replaceAll("[..,/]", ""));
        } else if (!path.contains("..") && !path.contains("/")) {
            p = String.format("%s/%s", p, path);
        } else {
            p = path;
        }
    }

    public String pwd() {
        return p;
    }
}
