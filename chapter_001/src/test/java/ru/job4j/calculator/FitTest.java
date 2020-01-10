package ru.job4j.calculator;

import org.junit.Assert;
import org.junit.Test;

public class FitTest {
    @Test
    public void manWeight() {
        double in = 176;
        double expected = 87.39;
        double out = Fit.manWeight(in);
        Assert.assertEquals(expected, out, 0.01);
    }

    @Test
    public void womanWeight() {
        double in = 169;
        double expected = 67.85;
        double out = Fit.womanWeight(in);
        Assert.assertEquals(expected, out, 0.01);
    }
}

//Этот метод возвращает double тип.
//Для сравнения результатов с типом double необходимо использовать метод с тремя параметрами.
//Число 0.01 используется для проверки, что результат теста будет в диапазоне [expected - 0.01, expected + 0.01].