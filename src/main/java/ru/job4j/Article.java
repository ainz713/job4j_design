package ru.job4j;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.RunnerException;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Benchmark)
@Fork(value = 1, warmups = 1)
@Warmup(iterations = 5)
@Measurement(iterations = 5)

public class Article {

    private final String originStr = "Мой дядя самых честных правил, "
            + "Когда не в шутку занемог, "
            + "Он уважать себя заставил "
            + "И лучше выдумать не мог. "
            + "Его пример другим наука; "
            + "Но, боже мой, какая скука "
            + "С больным сидеть и день и ночь, "
            + "Не отходя ни шагу прочь! "
            + "Какое низкое коварство "
            + "Полуживого забавлять, "
            + "Ему подушки поправлять, "
            + "Печально подносить лекарство, "
            + "Вздыхать и думать про себя: "
            + "Когда же черт возьмет тебя!";

    private final String testStr = "Мой дядя мог думать про тебя и день и ночь";

    public static boolean generateBy(String origin, String line) {
        HashSet<String> sp1 = new HashSet<>();
        String[] sp2 = line.replaceAll("[,.!;:]", "").split(" ");
        Collections.addAll(sp1, sp2);
        for (String s
                : sp1) {
            if (!origin.contains(s)) {
                return false;
            }
        }
        return true;
    }

    public static boolean generateBy2(String origin, String line) {
        boolean rsl = true;
        String[] originList = origin.split("[^а-яА-Яa-zA-Z]");
        Map<String, Integer> originMap = new HashMap<>();
        for (String s : originList) {
            originMap.put(s, null);
        }
        String[] lineList = line.split("[^а-яА-Яa-zA-Z]");
        for (String s : lineList) {
            if (!originMap.containsKey(s)) {
                rsl = false;
                break;
            }
        }
        return rsl;
    }

    @Benchmark
    public void testBy1() {
        generateBy(originStr, testStr);
    }

    @Benchmark
    public void testBy2() {
        generateBy2(originStr, testStr);
    }

    public static void main(String[] args) throws IOException, RunnerException {
        org.openjdk.jmh.Main.main(args);
    }
}
