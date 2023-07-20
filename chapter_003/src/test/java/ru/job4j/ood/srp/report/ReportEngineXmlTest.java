package ru.job4j.ood.srp.report;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.formatter.ReportDateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.model.Employees;
import ru.job4j.ood.srp.store.MemStore;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.util.Calendar;

import static org.assertj.core.api.Assertions.assertThat;

public class ReportEngineXmlTest {

    @Test
    public void whenGeneratedXml() throws JAXBException {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        DateTimeParser<Calendar> parser = new ReportDateTimeParser();
        store.add(worker);
        JAXBContext context = JAXBContext.newInstance(Employees.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        Report engine = new ReportEngineXml(store, parser, marshaller);
        StringBuilder expect = new StringBuilder()
                .append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
                        "<employees>\n" +
                        "    <employee>\n" +
                        "        <fired>2023-07-19T23:28:19.815+03:00</fired>\n" +
                        "        <hired>2023-07-19T23:28:19.815+03:00</hired>\n" +
                        "        <name>Ivan</name>\n" +
                        "        <salary>100.0</salary>\n" +
                        "    </employee>\n" +
                        "</employees>");
        assertThat(engine.generate(em -> true)).isEqualTo(expect.toString());
    }
}