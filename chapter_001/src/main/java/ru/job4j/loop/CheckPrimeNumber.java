package ru.job4j.loop;

public class CheckPrimeNumber {
    public static boolean check(int num) {
        int cnt = 0;
        boolean prime = false;
        for (int i = 1; i <= num; i++) {
            if (num % i == 0) {
                cnt++;
            }
        }
        if (cnt == 2) {
            prime = true;
        }
        return prime;
    }
}
