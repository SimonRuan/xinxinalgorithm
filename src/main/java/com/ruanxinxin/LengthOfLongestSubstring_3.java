package com.ruanxinxin;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * 示例 1:
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * 示例 4:
 * 输入: s = ""
 * 输出: 0
 * 提示：
 * 0 <= s.length <= 5 * 104
 * s 由英文字母、数字、符号和空格组成
 */
public class LengthOfLongestSubstring_3 {

    public int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1) {
            return s.length();
        }
        Set<Character> set = new HashSet<>();
        int max = 0;
        int end = 0;
        int start = 0;
        while (start < s.length()) {
            while (end < s.length()) {
                char item = s.charAt(end);
                if (!set.contains(item)) {
                    set.add(item);
                    end++;
                } else {
                    break;
                }
            }
            max = Math.max(max, set.size());
            set.remove(s.charAt(start++));
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new LengthOfLongestSubstring_3().lengthOfLongestSubstring("ab"));
    }

}
