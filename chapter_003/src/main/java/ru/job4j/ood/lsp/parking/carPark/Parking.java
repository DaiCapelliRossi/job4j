package ru.job4j.ood.lsp.parking.carPark;

import ru.job4j.ood.lsp.parking.car.Car;

import java.util.Arrays;

public class Parking implements ParkingInterface {
    private int LIGHT_NUMBER;
    private int TRUCK_NUMBER;

    private int lightCarsParked;
    private int trucksParked;

    private Car[] lightCarSlots;
    private Car[] truckSlots;

    public Parking(int lightCarSlotsNumber, int truckSlotsNumber) {
        this.LIGHT_NUMBER = lightCarSlotsNumber;
        this.TRUCK_NUMBER = truckSlotsNumber;
        lightCarSlots = new Car[lightCarSlotsNumber];
        truckSlots = new Car[truckSlotsNumber];
    }

    public boolean park(Car car) {
        if (car.isParked()) {
            System.out.println("This car is already parked");
            return false;
        }
        if (car.getSize() == 1) {
            if (parkAtLightCarSlot(car)) {
                lightCarsParked++;
                System.out.println("Light car was parked at light car slot");
                return true;
            }
        } else {
            if (parkAtTruckSlot(car)) {
                trucksParked++;
                System.out.println("Truck was parked at truck slot");
                return true;
            } else if (parkAtLightCarSlot(car)) {
                trucksParked++;
                System.out.println("Truck was parked at light car slot");
                return true;
            }
        }
        System.out.println("Parking is full!!!");
        return false;
    }

    public void leave(Car car) {
        if (!car.isParked()) {
            System.out.println("Car was never parked");
        }
        Car[] lightCarSlots = getLightCarSlots();
        for (int i = 0; i < lightCarSlots.length; i++) {
            if (lightCarSlots[i] == car) {
                lightCarSlots[i] = null;
            }
        }
        for (int i = 0; i < truckSlots.length; i++) {
            if (truckSlots[i] == car) {
                truckSlots[i] = null;
            }
        }
        car.setParked(false);
    }

    private boolean parkAtLightCarSlot(Car car) {
        int count = 0;
        for (int i = 0; i < lightCarSlots.length; i++) {
            if (lightCarSlots[i] == null) {
                count++;
                if (count == car.getSize()) {
                    for (int j = i - car.getSize() + 1; j <= i; j++) {
                        lightCarSlots[j] = car;
                    }
                    car.setParked(true);
                    return true;
                }
            } else {
                count = 0;
            }
        }
        return false;
    }

    private boolean parkAtTruckSlot(Car car) {
        for (int i = 0; i < truckSlots.length; i++) {
            if (truckSlots[i] == null) {
                truckSlots[i] = car;
                car.setParked(true);
                return true;
            }
        }
        return false;
    }

    public int countOccupiedSlots(Car[] carSlots) {
        int count = 0;
        for (Car carSlot : carSlots) {
            if (carSlot == null) {
                count++;
            }
        }

        return count;
    }

    public void printParkingInfo() {
        System.out.println("Light car slots: " + countOccupiedSlots(lightCarSlots) + "/" + LIGHT_NUMBER);
        System.out.println("Truck slots: " + countOccupiedSlots(truckSlots) + "/" + TRUCK_NUMBER);
        System.out.println("Parked light cars: " + lightCarsParked);
        System.out.println("Parked trucks: " + trucksParked);
        System.out.println(Arrays.toString(lightCarSlots));
        System.out.println(Arrays.toString(truckSlots));
        System.out.println("--------------------------------");

    }

    public int getLightCarsParked() {
        return lightCarsParked;
    }

    public void setLightCarsParked(int lightCarsParked) {
        this.lightCarsParked = lightCarsParked;
    }

    public int getTrucksParked() {
        return trucksParked;
    }

    public void setTrucksParked(int trucksParked) {
        this.trucksParked = trucksParked;
    }

    public Car[] getLightCarSlots() {
        return lightCarSlots;
    }

    public void setLightCarSlots(Car[] lightCarSlots) {
        this.lightCarSlots = lightCarSlots;
    }

    public Car[] getTruckSlots() {
        return truckSlots;
    }

    public void setTruckSlots(Car[] truckSlots) {
        this.truckSlots = truckSlots;
    }
}
