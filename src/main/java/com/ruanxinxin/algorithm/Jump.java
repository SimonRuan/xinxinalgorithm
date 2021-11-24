package com.ruanxinxin.algorithm;

import java.util.ArrayList;
import java.util.List;

public class Jump {


    static int solution(int[] arr) {
        int end = 0, maxPosition = 0, steps = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            maxPosition = Math.max(maxPosition, i + arr[i]);
            if (i == end) {
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }

    public static void main(String[] args) {
        int result=solution(new int[]{2,3,1,1,4,2,1});
        System.out.println(result);

        List list=new ArrayList<Integer>();
        list.add(3);
        list.add("sdfs");
        System.out.println(list);
    }

}
