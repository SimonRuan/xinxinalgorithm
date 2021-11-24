package com.ruanxinxin.mvc01.algorithm;

import org.springframework.util.StringUtils;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 */
public class LongestCommonPrefix {

    static String solution(String[] arr) {
        if (arr == null || arr.length == 0) return null;
        String result = arr[0];
        for (int i = 1; i < arr.length; i++) {
            while (arr[i].indexOf(result) != 0) {
                result = result.substring(0, result.length() - 1);
                if (StringUtils.isEmpty(result)) return result;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String[] arr = {"abcd", "dd", "dcba"};
        String result = solution(arr);
        System.out.println(result);
    }

}
