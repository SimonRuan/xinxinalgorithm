package com.ruanxinxin.algorithm;

import java.util.HashMap;
import java.util.Map;

public class RomanToInt {

    static int solution(String roman) {
        Map<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("IV", 4);
        map.put("V", 5);
        map.put("IX", 9);
        map.put("X", 10);
        map.put("XL", 40);
        map.put("L", 50);
        map.put("XC", 90);
        map.put("C", 100);
        map.put("CD", 400);
        map.put("D", 500);
        map.put("CM", 900);
        map.put("M", 1000);

        int result = 0;
        for (int i = 0; i < roman.length(); i++) {
            if (i <= (roman.length() - 2) && map.containsKey(roman.substring(i, i + 2))) {
                result += map.get(roman.substring(i, i + 2));
                i++;
            } else {
                result += map.get(roman.substring(i, i + 1));
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int result = solution("MCMXCIV");
        System.out.println(result);
    }

}
