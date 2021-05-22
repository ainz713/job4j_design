package ru.job4j.srp;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Test;
import java.util.Calendar;

public class ReportEngineTest {

    @Test
    public void whenOldGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new ReportEngine(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator())
                .append(worker.getName()).append(";")
                .append(worker.getHired()).append(";")
                .append(worker.getFired()).append(";")
                .append(worker.getSalary()).append(";")
                .append(System.lineSeparator());
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }

    @Test
    public void whenXmlGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new ReportXml(store);
        StringBuilder expect = new StringBuilder()
                .append("<?xml version=\"1.1\" encoding=\"UTF-8\" ?>\n")
                .append("<Employees>")
                .append("<Employee>")
                .append("<Name>").append(worker.getName())
                .append("</Name>")
                .append("<Hired>").append(worker.getHired())
                .append("</Hired>")
                .append("<Fired>").append(worker.getFired())
                .append("</Fired>")
                .append("<Salary>").append(worker.getSalary())
                .append("</Salary>")
                .append("</Employee>")
                .append("</Employees>");
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }

    @Test
    public void whenJsonGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new ReportJson(store);
        StringBuilder expect = new StringBuilder()
                .append("[\n")
                .append("\"employee\":{\n")
                .append("\"name\":\"").append(worker.getName())
                .append("\",\n\"hired\":\"").append(worker.getHired())
                .append("\",\n\"fired\":\"").append(worker.getFired())
                .append("\",\n\"salary\":\"").append(worker.getSalary())
                .append("\"\n}")
                .append("\n]");
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }
}