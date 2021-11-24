package com.ruanxinxin.algorithm;

import java.util.ArrayList;
import java.util.List;

public class BracketsCount {

    static List<String> result = new ArrayList<>();


    static void solution(String cur, int left, int right, int max) {
        if (cur.length() == 2 * max) {
            result.add(cur);
        } else {
            if (left < max) {
                solution(cur + "(", left + 1, right, max);
            }
            if (right < left) {
                solution(cur + ")", left, right + 1, max);
            }
        }
    }

    public static void main(String[] args) {
        solution("", 0, 0, 10);
        System.out.println(result);
    }
}
