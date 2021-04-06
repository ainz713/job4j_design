package ru.job4j.io;

import java.io.*;
import java.util.*;

public class ConsoleChat {
    private static final String OUT = "закончить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";
    private final String path;
    private final String botAnswers;

    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.botAnswers = botAnswers;
    }

    public void run() {
        List<String> log = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        List<String> botanswrs = read(botAnswers);
        System.out.println("Введите фразу:");
        boolean stop = false;
        String text = scanner.nextLine();
        log.add(String.format("%s%s", "Пользователь: ", text));
        while (!text.equals(OUT)) {
            if (Objects.equals(text, "")) {
                System.out.println("Вы ничего не ввели");
                System.out.println("Введите фразу:");
            }
            if (Objects.equals(text, STOP)) {
               stop = true;
            }
            if (Objects.equals(text, CONTINUE)) {
                stop = false;
            }
            Random random = new Random();
            if (!stop && !Objects.equals(text, "")) {
                int index = random.nextInt(botanswrs.size());
                System.out.println(botanswrs.get(index));
                log.add(String.format("%s%s", "Бот: ", botanswrs.get(index)));
            }
            text = scanner.nextLine();
            log.add(String.format("%s%s", "Пользователь: ", text));
        }
        write(log, path);
    }

    public static List<String> read(String file) {
        List<String> list = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(file))) {
            for (String line = in.readLine(); line != null; line = in.readLine()) {
                    list.add(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static void write(List<String> log, String file) {
        try (PrintWriter out = new PrintWriter(
                new BufferedOutputStream(
                        new FileOutputStream(file)
                ))) {
            for (String e
                    :log) {
                out.println(e);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ConsoleChat cc = new ConsoleChat("log.txt", "botanswers.txt");
        cc.run();
    }
}
