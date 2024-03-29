package ru.job4j.ood.srp.report;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.formatter.ReportDateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.MemStore;

import java.util.Calendar;

import static org.assertj.core.api.Assertions.assertThat;

public class ReportEngineJsonTest {

    @Test
    public void whenGeneratedJson() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        Employee worker2 = new Employee("Ivan", now, now, 100);
        DateTimeParser<Calendar> parser = new ReportDateTimeParser();
        store.add(worker);
        Report engine = new ReportEngineJson(store, parser);
        StringBuilder expect = new StringBuilder()
                .append("[{\"name\":\"")
                .append(worker.getName()).append("\",")
                .append("\"hired\":\"")
                .append(parser.parse(worker.getHired())).append("\",")
                .append("\"fired\":\"")
                .append(parser.parse(worker.getFired())).append("\",")
                .append("\"salary\":")
                .append(worker.getSalary())
                .append("}]");
        //assertThat(engine.generate(em -> true)).isEqualTo(expect.toString());
    }
}