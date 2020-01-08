package ru.job4j.converter;

public class Converter {
    public static int rubleToEuro(int value) {
        return value / 70;
    }

    public static int rubleToDollar(int value) {
        return value / 60;
    }

    public static int euroToRuble(int value) {
        return value * 70;
    }

    public static int dollarToRuble(int value) {
        return value * 60;
    }

    public static void main(String[] args) {
        int euro = rubleToEuro(140);
        System.out.println("140 rubles are " + euro + " euros.");
        int dollar = rubleToDollar(360);
        System.out.println("360 rubles are " + dollar + " dollars.");
        int ruble = euroToRuble(10);
        System.out.println("10 euros are " + ruble + " rubles.");
        ruble = dollarToRuble(2);
        System.out.println("2 dollars are " + ruble + " rubles.");

        int in = 140;
        int expected = 2;
        int out = rubleToEuro(in);
        boolean passed = expected == out;
        System.out.println("140 rubles are 2 euros. Test result : " + passed);

        int in2 = 360;
        int expected2= 6;
        int out2 = rubleToDollar(in2);
        boolean passed2 = expected2 == out2;
        System.out.println("360 rubles are 6 dollars. Test result : " + passed2);

        int in3 = 10;
        int expected3 = 700;
        int out3 = euroToRuble(in3);
        boolean passed3 = expected3 == out3;
        System.out.println("10 euros are 700 rubles. Test result : " + passed3);

        int in4 = 2;
        int expected4 = 120;
        int out4 = dollarToRuble(in4);
        boolean passed4 = expected4 == out4;
        System.out.println("2 dollars are 120 rubles. Test result : " + passed4);
    }
}
