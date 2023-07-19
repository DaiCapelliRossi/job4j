package ru.job4j.ood.srp.currency;

public class InMemoryCurrencyConverter implements CurrencyConverter {
    private static final int CURRENCIES_COUNT = Currency.values().length;
    private final double[][] convertationTable = new double[CURRENCIES_COUNT][CURRENCIES_COUNT];

    public InMemoryCurrencyConverter() {
        this.convertationTable[Currency.RUB.ordinal()][Currency.USD.ordinal()] = 0.0162;
        this.convertationTable[Currency.RUB.ordinal()][Currency.EUR.ordinal()] = 0.0166;
        this.convertationTable[Currency.USD.ordinal()][Currency.EUR.ordinal()] = 1.0218;
        this.convertationTable[Currency.USD.ordinal()][Currency.RUB.ordinal()] = 65D;
        this.convertationTable[Currency.EUR.ordinal()][Currency.USD.ordinal()] = 0.9786;
        this.convertationTable[Currency.EUR.ordinal()][Currency.RUB.ordinal()] = 63D;
    }

    @Override
    public double convert(Currency source, double sourceValue, Currency target) {
        return sourceValue * convertationTable[source.ordinal()][target.ordinal()];
    }
}
