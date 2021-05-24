package ru.job4j.jdbc;

import org.junit.Ignore;
import org.junit.Test;

import java.io.FileReader;
import java.util.Properties;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class TableEditorTest {

    @Ignore
    @Test
    public void checkTableEditor() throws Exception {
        final Properties properties = new Properties();
        properties.load(new FileReader("app.properties"));
        try (TableEditor tableEditor = new TableEditor(properties)) {
            tableEditor.createTable("test_table");
            tableEditor.addColumn("test_table", "name1", "text");
            tableEditor.addColumn("test_table", "amount1", "int");
            tableEditor.addColumn("test_table", "amount2", "int");
            tableEditor.renameColumn("test_table", "amount1", "amount");
            tableEditor.dropColumn("test_table", "amount2");

            StringBuilder expected = new StringBuilder();
            expected.append(String.format("%-15s %-15s%n", "column", "type"));
            expected.append(String.format("%-15s %-15s%n", "id", "serial"));
            expected.append(String.format("%-15s %-15s%n", "name", "varchar"));
            expected.append(String.format("%-15s %-15s%n", "name1", "text"));
            expected.append(String.format("%-15s %-15s%n", "amount", "int4"));
            assertThat(tableEditor.getScheme("test_table"), is(expected.toString()));
            tableEditor.dropTable("test_table");
            assertThat(tableEditor.getScheme("test_table"),
                    is(String.format("%-15s %-15s%n", "column", "type")));
        }
    }
}