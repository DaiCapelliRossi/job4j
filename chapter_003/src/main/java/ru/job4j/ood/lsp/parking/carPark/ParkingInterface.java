package ru.job4j.ood.lsp.parking.carPark;

import ru.job4j.ood.lsp.parking.car.Car;

public interface ParkingInterface {
    boolean park(Car car);
    void leave(Car car);

    int countOccupiedSlots(Car[] carSlots);
}
