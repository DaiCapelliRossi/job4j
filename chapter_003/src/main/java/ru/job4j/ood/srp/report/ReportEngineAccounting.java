package ru.job4j.ood.srp.report;

import ru.job4j.ood.srp.currency.Currency;
import ru.job4j.ood.srp.currency.CurrencyConverter;
import ru.job4j.ood.srp.currency.InMemoryCurrencyConverter;
import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.Store;

import java.util.Calendar;
import java.util.function.Predicate;

public class ReportEngineAccounting extends ReportEngine {

    public ReportEngineAccounting(Store store, DateTimeParser<Calendar> dateTimeParser) {
        super(store, dateTimeParser);
    }

    CurrencyConverter currencyConverter = new InMemoryCurrencyConverter();

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator());
        for (Employee employee : super.getStore().findBy(filter)) {
            text.append(employee.getName()).append(" ")
                    .append(super.getDateTimeParser().parse(employee.getHired())).append(" ")
                    .append(super.getDateTimeParser().parse(employee.getFired())).append(" ")
                    .append(currencyConverter.convert(Currency.USD, employee.getSalary(), Currency.RUB))
                    .append(System.lineSeparator());
        }
        return text.toString();
    }
}
