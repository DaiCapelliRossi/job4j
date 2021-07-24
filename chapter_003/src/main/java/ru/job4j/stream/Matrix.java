package ru.job4j.stream;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Matrix {
    public static void main(String[] args) {
        Integer[][] matrix = {{2, 4}, {2, 5}};

        System.out.println(
                Stream.of(matrix).flatMap(Arrays::stream).collect(Collectors.toList())
        );
    }
}
