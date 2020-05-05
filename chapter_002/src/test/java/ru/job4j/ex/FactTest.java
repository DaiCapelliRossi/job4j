package ru.job4j.ex;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;

public class FactTest {

    @Test(expected = IllegalArgumentException.class)
    public void whenNumberIsNegative() {
        Fact.calc(-19);
    }

    @Test
    public void whenNumberIsZeroOrPositive() {
        int rsl = Fact.calc(3);
        assertThat(rsl, is(6));
    }

}