package ru.job4j.collection;

import java.util.ArrayList;
import java.util.List;

public class ConvertList {
    public static List<Integer> convert(List<int[]> list) {
        int a = 1, b = 2, c = 4;
        List<Integer> rsl = new ArrayList<>();
        for (int[] l : list) {
            for (int i : l) {
                rsl.add(i);
            }
        }
        return rsl;
    }
}