package com.ruanxinxin.mvc01.algorithm;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidBrackets {

    private static boolean isValid(String orgin) {

        Map<Character, Character> map = new HashMap<>();
        map.put('}', '{');
        map.put(']', '[');
        map.put(')', '(');

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < orgin.length(); i++) {
            char c = orgin.charAt(i);
            if (map.containsKey(c) && !stack.isEmpty() && stack.peek() == map.get(c)) {
                stack.pop();
            } else {
                stack.push(orgin.charAt(i));
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        boolean result = isValid("[{}()(){(())}[]]");
        System.out.println(result);
    }

}
