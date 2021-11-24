package com.ruanxinxin.mvc01.algorithm;

/**
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 * 示例 1:
 * <p>
 * 输入: [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 * 示例 2:
 * <p>
 * 输入: [-2,0,-1]
 * 输出: 0
 * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 */
public class MaxProduct_152 {

    public int maxProduct(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int max = nums[0];
        int min = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            //必须用两个临时变量，因为改动了max之后，下面计算min的时候还会用到max
            int tempMax = max;
            int tempMin = min;
            max = Math.max(nums[i], Math.max(tempMax * nums[i], tempMin * nums[i]));
            min = Math.min(nums[i], Math.min(tempMax * nums[i], tempMin * nums[i]));
            res = Math.max(res, max);
        }
        return res;
    }
}
