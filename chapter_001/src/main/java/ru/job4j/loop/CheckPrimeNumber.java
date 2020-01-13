package ru.job4j.loop;

public class CheckPrimeNumber {
    public static boolean check(int num) {
        boolean prime = false;
        for (int i = 2; i <= num; i++) {
            if (num % i == 0 && num != i) {
                break;
            } else {
                prime = true;
            }
        }
        return prime;
    }
}
