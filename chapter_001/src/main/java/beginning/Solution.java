package beginning;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Количество букв
*/

public final class Solution {
    private static Solution instance = null;
    private Solution() {

    }

    public static Solution getInstance() {
        if (instance == null) {
            instance = new Solution();
        }
            return instance;

    }

}