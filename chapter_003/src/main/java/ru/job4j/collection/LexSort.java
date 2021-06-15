package ru.job4j.collection;

import java.sql.SQLOutput;
import java.util.Comparator;

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String left, String right) {

        int l = Integer.parseInt(left.substring(0, left.indexOf(".")));
        int r = Integer.parseInt(right.substring(0, right.indexOf(".")));

        if (l != r) {
            return Integer.compare(l, r);
        }
        return 0;
    }
}