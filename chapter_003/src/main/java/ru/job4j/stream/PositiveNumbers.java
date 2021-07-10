package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PositiveNumbers {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(7, -1, 4, 5, 45, 32, -245, -45, -9, 299);
        List<Integer> positiveNumbers = numbers.stream().filter(number -> number >= 0).collect(Collectors.toList());
        System.out.println(positiveNumbers);
    }
}
