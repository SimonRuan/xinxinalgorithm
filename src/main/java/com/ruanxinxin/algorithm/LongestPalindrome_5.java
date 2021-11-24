package com.ruanxinxin.algorithm;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * <p>
 * 示例 1：
 * <p>
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 * <p>
 * 输入: "cbbd"
 * 输出: "bb"
 */
public class LongestPalindrome_5 {

    public String longestPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int length1 = expandCenter(s, i, i);
            int length2 = expandCenter(s, i, i + 1);
            int tempMax = Math.max(length1, length2);
            if (tempMax > end - start) {
                start = i - (tempMax - 1) / 2;
                end = i + tempMax / 2;
            }
        }
        return s.substring(start, end + 1);

    }

    int expandCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left--) == s.charAt(right++)) {
        }
        return right - left + 1;
    }


}
