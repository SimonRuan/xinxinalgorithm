package com.ruanxinxin.mvc01.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * <p>
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * <p>
 * 示例:
 * <p>
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 说明:
 * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 */
public class LetterCombinations_17 {

    String[] charsArray = {
            "", //0
            "",//1
            "abc",//2
            "def",//3
            "ghi",//4
            "jkl",//5
            "mno",//6
            "pqrs",//7
            "tuv",//8
            "wxyz"//9
    };

    private List<String> resultList;

    public List<String> solution(String digits) {
        resultList = new ArrayList<>();
        if (digits == null || "".equals(digits)) {
            return resultList;
        }
        dfs("", digits, 0);
        return resultList;
    }

    public void dfs(String temp, String digits, int index) {
        if (index == digits.length()) {
            resultList.add(temp);
            return;
        }
        char current = digits.charAt(index);
        String str = charsArray[current - '0'];
        for (int i = 0; i < str.length(); i++) {
            dfs(temp + str.charAt(i), digits, index + 1);
        }
    }

    public static void main(String[] args) {
        List<String> solution = new LetterCombinations_17().solution("23");
        System.out.println(solution);
    }


}
