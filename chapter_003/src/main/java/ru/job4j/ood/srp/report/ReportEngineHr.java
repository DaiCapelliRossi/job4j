package ru.job4j.ood.srp.report;

import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.Store;
import java.util.Calendar;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class ReportEngineHr extends ReportEngine {

    public ReportEngineHr(Store store, DateTimeParser<Calendar> dateTimeParser) {
        super(store, dateTimeParser);
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        List<Employee> employees = getStore().findBy(filter);
        employees.sort(Comparator.comparing(Employee::getSalary).reversed());
        StringBuilder text = new StringBuilder();
        text.append("Name; Salary;")
                .append(System.lineSeparator());
        for (Employee employee : employees) {
            text.append(employee.getName()).append(" ")
                    .append(employee.getSalary())
                    .append(System.lineSeparator());
        }
        return text.toString();
    }
}
