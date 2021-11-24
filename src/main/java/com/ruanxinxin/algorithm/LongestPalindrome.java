package com.ruanxinxin.algorithm;

/**
 * 最长回文子串
 */
public class LongestPalindrome {


    static String solution(String str) {
        if (str == null || str.length() <= 1) {
            return str;
        }

        int start = 0, end = 0;//结果起、止索引

        for (int i = 0; i < str.length(); i++) {
            int length1 = centerExpand(str, i, i);
            int length2 = centerExpand(str, i, i + 1);
            int len = Math.max(length1, length2);
            if (len > (end - start)) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return str.substring(start, end + 1);
    }


    static int centerExpand(String str, int leftCenterIdx, int rightCenterIdx) {
        int length = 0;
        while (leftCenterIdx >= 0 && rightCenterIdx < str.length()
                && str.charAt(leftCenterIdx) == str.charAt(rightCenterIdx)) {
            length = rightCenterIdx - leftCenterIdx + 1;
            rightCenterIdx++;
            leftCenterIdx--;
        }
        return length;
    }


    public static void main(String[] args) {
        String str = "abbsldjcddbvccvbddcfklsfjdslkfjs";

        String result = solution(str);
        System.out.println(result);

    }

}
