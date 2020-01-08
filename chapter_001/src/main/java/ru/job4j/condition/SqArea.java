package ru.job4j.condition;

public class SqArea {
    public static double square(int p, int k) {
        return (p / 2) / (k + 1) * (k * p / 2) / (k + 1);
    }

    public static void main(String[] args) {
        double result1 = square(9, 3);
        System.out.println(" p = 9, k = 3, s = 3, real = " + result1);
    }
}

//Задача на стороны прямоугольника