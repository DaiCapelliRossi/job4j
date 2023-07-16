package ru.job4j.kiss;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;


public class MaxMinTest {

    @Test
    public void whenMax() {
        MaxMin maxMin = new MaxMin();
        List<Integer> list = List.of(1, 10, 3);
        Comparator<Integer> comparator = Comparator.comparingInt(o -> o);
        assertThat(maxMin.max(list, comparator), is(10));
    }

    @Test
    public void whenMin() {
        MaxMin maxMin = new MaxMin();
        List<Integer> list = List.of(1, 10, 3);
        Comparator<Integer> comparator = Comparator.comparingInt(o -> o);
        assertThat(maxMin.min(list, comparator), is(1));
    }

    @Test
    public void whenEmpty() {
        MaxMin maxMin = new MaxMin();
        List<Integer> list = new ArrayList<>();
        Comparator<Integer> comparator = Comparator.comparingInt(o -> o);
        assertNull(maxMin.max(list, comparator));
    }
    @Test

    public void whenOneElement() {
        MaxMin maxMin = new MaxMin();
        List<Integer> list = List.of(1);
        Comparator<Integer> comparator = Comparator.comparingInt(o -> o);
        assertThat(maxMin.max(list, comparator), is(1));
    }
}