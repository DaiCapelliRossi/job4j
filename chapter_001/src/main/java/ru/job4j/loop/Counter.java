package ru.job4j.loop;

public class Counter {
    public static int add(int start, int finish) {
        int sum = 0;
        for (int n = start; n <= finish; n++) {
            if (n % 2 == 0) {
                sum += n;
            }

        }
        return sum;
    }
}
