package ru.job4j.generics;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Test;

import java.util.Iterator;

public class SimpleArrayTest {

    @Test
    public void whenAdd() {
       SimpleArray<Integer> array = new SimpleArray(3);
        array.add(2);
        Iterator<Integer> it = array.iterator();
        assertThat(it.next(), is(2));
    }

    @Test
    public void whenRemove() {
        SimpleArray<Integer> array = new SimpleArray(3);
        array.add(2);
        array.add(3);
        array.remove(1);
        Iterator<Integer> it = array.iterator();
        assertThat(it.next(), is(2));
    }

    @Test
    public void whenSet() {
        SimpleArray<Integer> array = new SimpleArray(3);
        array.add(2);
        array.set(0, 3);
        Iterator<Integer> it = array.iterator();
        assertThat(it.next(), is(3));
    }

    @Test
    public void whenGet() {
        SimpleArray<Integer> array = new SimpleArray(3);
        array.add(2);
        array.set(0, 3);
        assertThat(array.get(0), is(3));
    }
}