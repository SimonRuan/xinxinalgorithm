package com.ruanxinxin.mvc01.algorithm;

import java.util.*;

public class BracketsIsValid_20 {

    public boolean isValid(String s) {
        //空字符串 true
        if (s == null || s.length() == 0) {
            return true;
        }
        //长度为奇数，false
        if ((s.length() & 1) == 1) {
            return false;
        }

        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        LinkedList<Character> stack = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            //右括号，跟栈顶元素匹配是否是一对
            if (map.containsKey(c)) {
                if (stack.pollLast() != map.get(c)) {
                    return false;
                }
            } else {
                stack.addLast(c);
            }
        }
        return stack.isEmpty();
    }


}
