package ru.job4j.tracker;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*
Одинаковые слова в списке
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> words = new ArrayList<String>();
        for (int i = 0; i < 20; i++) {
            words.add(reader.readLine());
        }

        Map<String, Integer> map = countWords(words);

        for (Map.Entry<String, Integer> pair : map.entrySet()) {
            System.out.println(pair.getKey() + " " + pair.getValue());
        }
    }

    public static Map<String, Integer> countWords(ArrayList<String> list) {
        HashMap<String, Integer> result = new HashMap<String, Integer>();

        int cnt = 0;
        String key;
        while (list.size() != 0) {
            key = list.get(0);
            if (list.contains(key)) {
                for (int i = 0; i < list.size(); i++) {
                    if (key.equals(list.get(i))) {
                        cnt++;
                        list.remove(i);
                        i--;
                    }
                }

            }

            result.put(key, cnt);
            cnt = 0;
        }


        return result;
    }

}

