package com.ruanxinxin.algorithm;

public class SearchRange_34 {

    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }
        int left = binSearch(nums, target, true);
        if (left == -1) {
            return new int[]{-1, -1};
        }
        int[] res = {left, binSearch(nums, target, false)};
        return res;
    }

    int binSearch(int nums[], int target, boolean fromLeft) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            // 坑1：从左根从右 mid取值不一样
            int mid = fromLeft ? (left + right) / 2 : (left + right + 1) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] == target) {
                if (fromLeft) {
                    right = mid;
                } else {
                    left = mid;
                }
            } else {
                right = mid - 1;
            }
        }
        if (fromLeft) {
            if (nums[left] == target) {
                return left;
            }
            return -1;
        }
        return left;
    }

    public static void main(String[] args) {
        int[] nums = {2, 2};
        System.out.println(new SearchRange_34().searchRange(nums, 8));
    }
}
