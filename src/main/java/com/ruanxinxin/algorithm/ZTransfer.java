package com.ruanxinxin.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 */
public class ZTransfer {

    static String solution(String origin, int rowNum) {

        if (rowNum <= 1 || origin.length() <= rowNum) return origin;

        //每行一个StringBuilder
        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < rowNum; i++) {
            rows.add(new StringBuilder());
        }

        int rowIdx = 0;
        boolean down = false;

        for (char c : origin.toCharArray()) {
            rows.get(rowIdx).append(c);
            if (rowIdx == 0 || rowIdx == rowNum - 1) down = !down;
            rowIdx += down ? 1 : -1;
        }
        StringBuilder sb = new StringBuilder();
        for (StringBuilder item : rows) {
            sb.append(item);
        }
        return sb.toString();

    }


    public static void main(String[] args) {
        String origin = "LEETCODEISHIRING";
        String result = solution(origin, 4);
        System.out.println(result);
    }

}
