package ru.job4j.template;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class GeneratorTest {

    private Map<String, String> map;
    private Generator generator;

    @Before
    public void init() {
        map = new HashMap<>();
        generator = new Generator3();
        map.put("name", "Zeliboba");
        map.put("subject", "you");
    }

    @Test
    public void produce() {
        String s = generator.produce("I am a ${name}, Who are ${subject}? ", map);
        assertThat(s, is("I am a Zeliboba, Who are you? "));
    }

    @Test(expected = IllegalStateException.class)
    public void whenNotEnoughKeyInM() {
        String s = generator.produce("I am a ${name}, Who are ${subject} ${object}? ", map);
    }

    @Test(expected = IllegalStateException.class)
    public void whenMoreThanEnough() {
        map.put("object", "you");
        String s = generator.produce("I am a ${name}, Who are ${subject}? ", map);
    }
}