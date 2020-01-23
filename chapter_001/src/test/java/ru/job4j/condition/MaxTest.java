package ru.job4j.condition;

import org.junit.Test;
import ru.job4j.condition.Max;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MaxTest {
    @Test
    public void whenMax1To2Then2() {
        int result = Max.max(1, 2);
        assertThat(result, is(2));
    }
    @Test
    public void whenMax3To2And1Then3() {
        int result = Max.max(2, 1, 3);
        assertThat(result, is(3));
    }
    @Test
    public void whenMax4To3And2And1Then4() {
        int result = Max.max(1, 4, 3, 2);
        assertThat(result, is(4));
    }
}
