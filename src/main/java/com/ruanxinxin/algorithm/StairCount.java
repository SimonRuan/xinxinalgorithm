package com.ruanxinxin.algorithm;

public class StairCount {

    static int stairCount(int floor) {
        if (floor <= 0) throw new RuntimeException();
        if (floor == 1) return 1;
        if (floor == 2) return 2;
        return stairCount(floor - 1) + stairCount(floor - 2);
    }

    public static void main(String[] args) {
        for (int i = 1; i < 10; i++) {
            System.out.println(i + "层楼梯的上法有：" + stairCount(i) + " 种；");
        }
    }

}
