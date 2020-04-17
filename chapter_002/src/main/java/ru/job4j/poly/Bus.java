package ru.job4j.poly;

public class Bus implements Transport {

    @Override
    public void drive() {
    }

    @Override
    public void passengers(int number) {
    }

    @Override
    public double fillGas(double gas) {
        return gas * 2;
    }
}
