package com.ruanxinxin.mvc01.algorithm;

/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 */
public class ReverseInt {

    static int solution(int origin) {
        int result = 0;
        while (origin != 0) {
            int pop = origin % 10;
            origin /= 10;

            if (result > Integer.MAX_VALUE / 10 ||
                    (result == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (result < Integer.MIN_VALUE / 10 ||
                    (result == Integer.MIN_VALUE / 10 && pop < -8)) return 0;

            result = 10 * result + pop;
        }

        return result;
    }

    public static void main(String[] args) {
        int origin = 321;//123
        int result = solution(origin);
        System.out.println(result);
    }

}
