package ru.job4j.srp;

import java.util.function.Predicate;

public class ReportXml implements Report {

    private Store store;

    public ReportXml(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("<?xml version=\"1.1\" encoding=\"UTF-8\" ?>\n");
        text.append("<Employees>");
        for (Employee employee : store.findBy(filter)) {
            text.append("<Employee>")
                    .append("<Name>")
                    .append(employee.getName())
                    .append("</Name>")
                    .append("<Hired>")
                    .append(employee.getHired())
                    .append("</Hired>")
                    .append("<Fired>")
                    .append(employee.getFired())
                    .append("</Fired>")
                    .append("<Salary>")
                    .append(employee.getSalary())
                    .append("</Salary>")
                    .append("</Employee>");
        }
        text.append("</Employees>");
        return text.toString();
    }
}
