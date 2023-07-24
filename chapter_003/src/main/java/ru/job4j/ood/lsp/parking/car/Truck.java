package ru.job4j.ood.lsp.parking.car;

import ru.job4j.ood.lsp.parking.carPark.Parking;

public class Truck implements Car {
    private String number;
    private int size;
    private boolean isParked;

    public Truck(String number, int size) {
        this.number = number;
        this.size = size;
        this.isParked = false;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public boolean isParked() {
        return isParked;
    }

    @Override
    public void setParked(boolean parked) {
        isParked = parked;
    }

    @Override
    public String toString() {
        return "Truck : " +
                number;
    }
}
