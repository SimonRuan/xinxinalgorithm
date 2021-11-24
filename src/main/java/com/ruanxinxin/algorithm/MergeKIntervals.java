package com.ruanxinxin.algorithm;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeKIntervals {

    public int[][] merge(int[][] intervals) {

        if (intervals == null || intervals.length <= 1) {
            return intervals;
        }

        Arrays.sort(intervals, (i1,i2)->i1[0]-i2[0]);

        List<int[]> merged = new ArrayList<>();

        int[] current = intervals[0];
        merged.add(current);
        for (int i = 1; i < intervals.length; i++) {

            //第i个区间的左界<=current的右界，可以合并到current：左界不变，右界为max(i的右界,current右界)
            if (intervals[i][0] <= current[1]) {
                current[1] = Math.max(intervals[i][1], current[1]);
            } else {//current放到
                current = intervals[i];
                merged.add(current);
            }
        }

        return merged.toArray(new int[merged.size()][]);
    }


    public static void main(String[] args) {
        int[][] intervals = {{4, 5}, {0, 2}};
        intervals = new MergeKIntervals().merge(intervals);
        System.out.println(intervals);

    }
}


