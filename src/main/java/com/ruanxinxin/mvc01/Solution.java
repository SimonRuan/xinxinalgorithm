package com.ruanxinxin.mvc01;

class Solution {
    public void nextPermutation(int[] nums) {
        if (nums.length <= 1) {
            return;
        }

         int i = nums.length - 1;
        while (i >= 1 && nums[i] <= nums[i - 1]) {
            i--;
        }
        if (i > 0) {
            for (int j = nums.length - 1; j > i; j--) {
                if (nums[j] > nums[i]) {
                    swap(nums, i, j);
                    break;
                }
            }
        }
        reverseFromI(nums, i);
    }

    void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    void reverseFromI(int[] nums, int i) {
        int j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        new Solution().nextPermutation(nums);
    }
}
