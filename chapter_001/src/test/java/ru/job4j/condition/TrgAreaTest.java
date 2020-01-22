package ru.job4j.condition;

import org.junit.Test;
import ru.job4j.condition.Triangle;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TrgAreaTest {
    @Test
    public void whenExist() {
        Point a = new Point(2, 0);
        Point b = new Point(0, 2);
        Point c = new Point(0, 0);
        TrgArea trgArea = new TrgArea(a, b, c);
        double result = trgArea.area();
        assertThat(result, is(1.9999999999999991));
    }

    @Test
    public void whenDoesntExist() {
        Point a = new Point(2, 0);
        Point b = new Point(0, 2);
        Point c = new Point(1, 1);
        TrgArea trgArea = new TrgArea(a, b, c);
        double result = trgArea.area();
        assertThat(result, is(-1.0));
    }
}
