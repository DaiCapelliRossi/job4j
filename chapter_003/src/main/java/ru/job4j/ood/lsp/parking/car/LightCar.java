package ru.job4j.ood.lsp.parking.car;

import ru.job4j.ood.lsp.parking.carPark.Parking;

import java.util.Objects;

public class LightCar implements Car {
    private String number;
    private int size;
    private boolean isParked;

    public LightCar(String number) {
        this.number = number;
        this.size = 1;
        isParked = false;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean isParked() {
        return isParked;
    }

    public void setParked(boolean parked) {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LightCar lightCar = (LightCar) o;
        return number.equals(lightCar.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return "LightCar : " +
                number;
    }
}
