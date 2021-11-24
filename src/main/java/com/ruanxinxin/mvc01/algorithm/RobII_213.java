package com.ruanxinxin.mvc01.algorithm;

import java.util.Arrays;

/**
 * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。
 * 这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。
 * 同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
 * <p>
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，能够偷窃到的最高金额。
 */
public class RobII_213 {

    public int robII(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            return nums[0];
        }
        return Math.max(myRob(Arrays.copyOfRange(nums, 0, nums.length - 1)),
                myRob(Arrays.copyOfRange(nums, 1, nums.length)));
    }

    public int myRob(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            return nums[0];
        }
        //第一维代表房间，第二维代表偷或不偷 0不偷 1偷
        int[][] dp1 = new int[len + 1][2];
        dp1[1][0] = 0;
        dp1[1][1] = nums[0];
        dp1[2][0] = nums[0];
        dp1[2][1] = nums[1];
        for (int i = 3; i < len + 1; i++) {
            dp1[i][0] = Math.max(dp1[i - 1][0], dp1[i - 1][1]);
            dp1[i][1] = Math.max(dp1[i - 1][0] + nums[i - 1], dp1[i - 1][1]);
        }
        return Math.max(dp1[len][0], dp1[len][1]);
    }

}
