package ru.job4j.calculator;

public class Fit {
    public static double manWeight(double height) {
        return (height - 100) * 1.15;
    }

    public static double womanWeight(double height) {
        return (height - 110) * 1.15;
    }

    public static void main(String[] args) {
        double man = manWeight(176);
        System.out.println("Man 176 is " + man);
        double woman = womanWeight(169);
        System.out.println("Woman 169 is " + woman);
    }
}
