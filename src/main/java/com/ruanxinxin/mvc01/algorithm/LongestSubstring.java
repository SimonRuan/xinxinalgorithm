package com.ruanxinxin.mvc01.algorithm;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstring {


    static String solution(String s) {
        int resultLeft = 0, resultRight = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int  left = 0,right = 0; right < s.length(); right++) {
            if (map.containsKey(s.charAt(right))) {
                left = Math.max(map.get(s.charAt(right)), left);
            }
            if ((resultRight - resultLeft) < (right - left)) {
                resultLeft = left;
                resultRight = right;
            }
            map.put(s.charAt(right), right + 1);
        }
        return s.substring(resultLeft, resultRight + 1);
    }

    public static void main(String[] args) {
        String result = solution("aabbccdd");
        System.out.println(result);
    }

}
