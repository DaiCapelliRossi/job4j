package ru.job4j.condition;

import org.hamcrest.core.Is;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class SqMaxTest {
    @Test
    public void firstIsMax() {
        int result = SqMax.max(4, 3, 2, 1);
        assertThat(result, Is.is(4));
    }

    @Test
    public void secondIsMax() {
        int result = SqMax.max(3, 4, 2, 1);
        assertThat(result, Is.is(4));
    }

    @Test
    public void thirdIsMax() {
        int result = SqMax.max(2, 3, 4, 1);
        assertThat(result, Is.is(4));
    }

    @Test
    public void forthtIsMax() {
        int result = SqMax.max(1, 3, 2, 4);
        assertThat(result, Is.is(4));
    }
}
