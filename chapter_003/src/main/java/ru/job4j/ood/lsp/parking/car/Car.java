package ru.job4j.ood.lsp.parking.car;

import ru.job4j.ood.lsp.parking.carPark.Parking;

public interface Car {
    int getSize();

    boolean isParked();

    void setParked(boolean parked);

}
