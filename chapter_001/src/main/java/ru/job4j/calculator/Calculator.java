package ru.job4j.calculator;

/**
 * Calculator Класс для вычисления арифметических операций
 *
 * @author Anastasia Ostroumova (ness.ostroumova@gmail.com)
 * @since 11.01.2020
 * @version 1
 */

public class Calculator {

    /**
     * Сложение.
     * @param first первый аргумент
     * @param second второй аргумент
     * @return результат сложения
     */
    public static void add(double first, double second) {
        double result =  first + second;
        System.out.println(first + " + " + second + " = " + result);
    }

    /**
     * Деление.
     * @param first первый аргумент
     * @param second второй аргумент
     * @return результат деления
     */
    public static void div(double first, double second) {
        double result = first / second;
        System.out.println(first + " / " + second + " = " + result);
    }

    /**
     * Умножение.
     * @param first первый аргумент
     * @param second второй аргумент
     * @return результат умножения
     */
    public static void multiply(double first, double second) {
        double result = first * second;
        System.out.println(first + " * " + second + " = " + result);
    }

    /**
     * Вычитание.
     * @param first первый аргумент
     * @param second второй аргумент
     * @return результат вычитания
     */
    public static void subtract(double first, double second) {
        double result = first - second;
        System.out.println(first + " - " + second + " = " + result);
    }

    public static void main(String[] args) {
        add(1, 1);
        div(4, 2);
        multiply(2, 1);
        subtract(10, 5);
    }

}
