package ru.job4j;

import org.junit.Test;

import java.util.*;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class AnalizeTest {

    @Test
    public void whenDeleteUsers() {
        List<Analize.User> previous = new ArrayList<>(Arrays.asList(
                new Analize.User(1, "aaa"),
                new Analize.User(2, "bbb"),
                new Analize.User(3, "ccc"),
                new Analize.User(4, "ddd")));
        List<Analize.User> current = new ArrayList<>(Arrays.asList(
                new Analize.User(1, "aaa"),
                new Analize.User(2, "bbb")));
        Analize.Info rsl = Analize.diff(previous, current);
        assertThat(rsl.toString(), is("Info{added=0, changed=0, deleted=2}"));
    }

    @Test
    public void whenChangeUsers() {
        List<Analize.User> previous = new ArrayList<>(Arrays.asList(
                new Analize.User(1, "aaa"),
                new Analize.User(2, "bbb"),
                new Analize.User(3, "ccc"),
                new Analize.User(4, "ddd")));
        List<Analize.User> current = new ArrayList<>(Arrays.asList(
                new Analize.User(1, "eee"),
                new Analize.User(2, "fff"),
                new Analize.User(3, "ggg"),
                new Analize.User(4, "hhh")));
        Analize.Info rsl = Analize.diff(previous, current);
        assertThat(rsl.toString(), is("Info{added=0, changed=4, deleted=0}"));
    }

    @Test
    public void whenAddUsers() {
        List<Analize.User> previous = new ArrayList<>(Arrays.asList(
                new Analize.User(1, "aaa"),
                new Analize.User(2, "bbb")));
        List<Analize.User> current = new ArrayList<>(Arrays.asList(
                new Analize.User(1, "aaa"),
                new Analize.User(2, "bbb"),
                new Analize.User(3, "ccc"),
                new Analize.User(4, "ddd")));
        Analize.Info rsl = Analize.diff(previous, current);
        assertThat(rsl.toString(), is("Info{added=2, changed=0, deleted=0}"));
    }

    @Test
    public void whenAddAndDeleteUsers() {
        List<Analize.User> previous = new ArrayList<>(Arrays.asList(
                new Analize.User(1, "aaa"),
                new Analize.User(2, "bbb"),
                new Analize.User(3, "ccc")));
        List<Analize.User> current = new ArrayList<>(Arrays.asList(
                new Analize.User(1, "aaa"),
                new Analize.User(3, "ddd"),
                new Analize.User(4, "eee")));
        Analize.Info rsl = Analize.diff(previous, current);
        assertThat(rsl.toString(), is("Info{added=1, changed=1, deleted=1}"));
    }

    @Test
    public void whenAdd10AndDelete5() {
        List<Analize.User> previous = new ArrayList<>(Arrays.asList(
                new Analize.User(1, "a1"),
                new Analize.User(2, "a2"),
                new Analize.User(3, "a3"),
                new Analize.User(4, "a4"),
                new Analize.User(5, "a5"),
                new Analize.User(6, "a6"),
                new Analize.User(7, "a7"),
                new Analize.User(8, "a8"),
                new Analize.User(9, "a9"),
                new Analize.User(10, "a10")));
        List<Analize.User> current = new ArrayList<>(Arrays.asList(
                new Analize.User(11, "aaa"),
                new Analize.User(12, "ddd"),
                new Analize.User(13, "ddd"),
                new Analize.User(14, "ddd"),
                new Analize.User(15, "eee")));
        Analize.Info rsl = Analize.diff(previous, current);
        assertThat(rsl.toString(), is("Info{added=5, changed=0, deleted=10}"));
    }
}