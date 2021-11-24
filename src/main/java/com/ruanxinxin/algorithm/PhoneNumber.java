package com.ruanxinxin.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].(不要求顺序)
 */
public class PhoneNumber {

    final static Map<String, String> map = new HashMap<String, String>() {
        {
            put("2", "abc");
            put("3", "def");
            put("4", "ghi");
            put("5", "jkl");
            put("6", "mno");
            put("7", "pqrs");
            put("8", "tuv");
            put("9", "wxyz");
        }
    };

    static List<String> result = new ArrayList<>();

    public static void main(String[] args) {
        String input = "23";
        backtrack("", input);
        System.out.println(result);
    }

    static void backtrack(String combination, String nextDigits) {
        if (nextDigits == null || nextDigits.equals("")) {
            result.add(combination);
        } else {
            String letters = map.get(nextDigits.substring(0, 1));//余下的第一个数字对应的字母
            for (int i = 0; i < letters.length(); i++) {
            }
        }

    }
}
