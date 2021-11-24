package com.ruanxinxin.algorithm;

import java.util.ArrayList;
import java.util.List;

public class BracketsCount_22 {
    List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        if(n <= 0){
            return res;
        }
        dfs("", 0, 0, n);
        return res;
    }

    void dfs(String sb, int left, int right, int n) {
        if (sb.length() == 2 * n) {
            res.add(sb);
            return;
        }
        //加左括号
        if (left < n) {
            dfs(sb + "(", left + 1, right, n);
        }
        //加右括号
        if (left <= n && right < left) {
            dfs(sb + ")", left, right + 1, n);
        }
    }

    public static void main(String[] args) {
        System.out.println(new BracketsCount_22().generateParenthesis(3));
    }
}
