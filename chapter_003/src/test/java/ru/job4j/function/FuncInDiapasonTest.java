package ru.job4j.function;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class FuncInDiapasonTest {

    @Test
    public void whenLinearFunctionThenLinearResults() {

       List<Double> result = FuncInDiapason.diapason(5, 8, x -> 2 * x + 1);
       List<Double> expected = Arrays.asList(11D, 13D, 15D);
       assertThat(result, is(expected));
    }

    @Test
    public void whenQuadraticFunctionThenQuadraticResults() {

        List<Double> result = FuncInDiapason.diapason(5, 8, x -> 2 * x * x + 7 * x + 5);
        List<Double> expected = Arrays.asList(90D, 119D, 152D);
        assertThat(result, is(expected));
    }
    
    @Test
    public void whenExponentialFunctionThenExponentialResults() {

        List<Double> result = FuncInDiapason.diapason(5, 8, x -> Math.pow(2, x));
        List<Double> expected = Arrays.asList(32D, 64D, 128D);
        assertThat(result, is(expected));
    }

}