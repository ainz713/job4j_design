package ru.job4j.isp;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

public class MenuRezTest {

    private MenuRez menu;

    @Before
    public void init() {
        menu = new MenuRez(new Node("Задача 0", new SimpleAction()));
    }

    @Test
    public void whenPrintMenu() {
        menu.add("Задача 0", "Задача 1.", new SimpleAction());
        menu.add("Задача 1.", "Задача 1.1.", new SimpleAction());
        menu.add("Задача 1.", "Задача 1.2.", new SimpleAction());
        menu.add("Задача 1.2.", "Задача 1.2.1.", new SimpleAction());
        menu.add("Задача 1.1.", "Задача 1.1.1.", new SimpleAction());
        menu.add("Задача 0", "Задача 2.", new SimpleAction());
        String rsl = menu.print();

        StringBuilder expected = new StringBuilder()
                .append("Задача 1.\r\n")
                .append("----Задача 1.1.\r\n")
                .append("--------Задача 1.1.1.\r\n")
                .append("----Задача 1.2.\r\n")
                .append("--------Задача 1.2.1.\r\n")
                .append("Задача 2.\r\n");
        System.out.println(expected);
        assertThat(rsl, is(expected.toString()));
    }
}