package ru.job4j.ood.srp.report;

import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.model.Employees;
import ru.job4j.ood.srp.store.Store;

import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Calendar;
import java.util.function.Predicate;

public class ReportEngineXml extends ReportEngine {
    private Marshaller marshaller;
    public ReportEngineXml(Store store, DateTimeParser<Calendar> dateTimeParser, Marshaller marshaller) {
        super(store, dateTimeParser);
        this.marshaller = marshaller;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        var employees = getStore().findBy(filter);
        String xml = "";
        try (StringWriter writer = new StringWriter()) {
            try {
                marshaller.marshal(new Employees(employees), writer);
            } catch (JAXBException e) {
                throw new RuntimeException(e);
            }
            xml = writer.getBuffer().toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return xml;
    }
}