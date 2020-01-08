package ru.job4j.calculator;

public class CarUsage {
    public static void main(String[] args) {
        Car bmw = new Car();
        boolean driving = bmw.canDrive();
        String carSays = driving ? "I can drive" : "I can't drive";
        System.out.println(carSays);
        System.out.println("Can you drive?:" + driving);
        System.out.println("I am going to a gas station.");
        int gas = 25;
        bmw.fill(gas);
        driving = bmw.canDrive();
        System.out.println("Can you drive now?:" + driving);
        System.out.println("Now, I am going to my granny.");
        System.out.println("It's 10 kilometers from here");
        int distance = 10;
        bmw.drive(distance);
        bmw.gasInfo();
    }
}
