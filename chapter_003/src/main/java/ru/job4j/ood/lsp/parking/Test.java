package ru.job4j.ood.lsp.parking;

import ru.job4j.ood.lsp.parking.car.Car;
import ru.job4j.ood.lsp.parking.car.LightCar;
import ru.job4j.ood.lsp.parking.car.Truck;
import ru.job4j.ood.lsp.parking.carPark.Parking;

public class Test {
    public static void main(String[] args) {
        Parking parking = new Parking(10, 2);
        parking.printParkingInfo();
        Car truck1 = new Truck("A456BC", 4);
        Car truck2 = new Truck("N123EF", 3);
        Car truck3 = new Truck("A2221QB", 5);
        Car truck4 = new Truck("B2221QB", 9);
        Car lightCar1 = new LightCar("A111EE");
        parking.park(truck1);
        parking.park(truck2);
        parking.park(truck3);
        parking.leave(truck3);
        parking.park(lightCar1);
        parking.park(truck4);
        parking.printParkingInfo();

    }
}
