package ru.job4j.jdbc;

import org.junit.Ignore;
import org.junit.Test;

import java.io.FileReader;
import java.util.Properties;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class PrepareStatementDemoTest {

    @Ignore
    @Test
    public void checkTableEditor() throws Exception {
        PrepareStatementDemo prep = new PrepareStatementDemo();
        final Properties properties = new Properties();
        properties.load(new FileReader("app.properties"));
        TableEditor tableEditor = new TableEditor(properties);
        City city1 = new City(1, "Moscow", 6700);
        prep.insert(city1);
        StringBuilder expected = new StringBuilder();
        expected.append(String.format("%-15s %-15s%n", "column", "type"));
        expected.append(String.format("%-15s %-15s%n", "id", "serial"));
        expected.append(String.format("%-15s %-15s%n", "name", "text"));
        expected.append(String.format("%-15s %-15s%n", "population", "int4"));
        assertThat(tableEditor.getScheme("cities"), is(expected.toString()));
        }
    }