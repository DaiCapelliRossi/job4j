package ru.job4j.converter;

import org.junit.Assert;
import org.junit.Test;

public class ConverterTest {
    @Test
    public void rubleToEuro() {
        int in = 140;
        int expected = 2;
        int out = Converter.rubleToEuro(in);
        Assert.assertEquals(expected, out);
    }
//По аналогии с кодом в методе main мы объявляем входящие данные in,
//ожидаемые данные expected и результат вычисления метода Converter.rubleToEuro записываем в фактические данные.
//Дальше в методе main мы используем вывод информации на консоль.
//В случае использовании junit мы должны вызывать метод из этой библиотеки, который сравнит два значения:
//результат вычисления и ожидаемый результат.
//Для этого используется вызов метод Assert.assertEquals
//Чтобы вызвать метод из другого класса мы указываем имя класса и через точку указываем метод,
//который хотим вызвать с указанием параметров этого метода.

    @Test
    public void rubleToDollar() {
        int in = 360;
        int expected = 6;
        int out = Converter.rubleToDollar(in);
        Assert.assertEquals(expected, out);
    }

    @Test
    public void euroToRuble() {
        int in = 10;
        int expected = 700;
        int out = Converter.euroToRuble(in);
        Assert.assertEquals(expected, out);
    }

    @Test
    public void dollarToRuble() {
        int in = 2;
        int expected = 120;
        int out = Converter.dollarToRuble(in);
        Assert.assertEquals(expected, out);
    }
}
