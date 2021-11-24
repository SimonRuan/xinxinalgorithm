package com.ruanxinxin.algorithm;

/**
 * 给你一个整数数组 nums ，和一个整数 target 。
 * <p>
 * 该整数数组原本是按升序排列，但输入时在预先未知的某个点上进行了旋转。（例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] ）。
 * <p>
 * 请你在数组中搜索 target ，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 * 示例 1：
 * 输入：nums = [4,5,6,7,0,1,2], target = 0
 * 输出：4
 * 示例 2：
 * 输入：nums = [4,5,6,7,0,1,2], target = 3
 * 输出：-1
 * 示例 3：
 * 输入：nums = [1], target = 0
 * 输出：-1
 * 提示：
 * <p>
 * 1 <= nums.length <= 5000
 * -10^4 <= nums[i] <= 10^4
 * nums 中的每个值都 独一无二
 * nums 肯定会在某个点上旋转
 * -10^4 <= target <= 10^4
 */
public class RotateSearch_33 {

    public int search(int[] nums, int target) {
        if (nums.length == 1) {
            return nums[0] == target ? 0 : -1;
        }
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return mid;
                //左边是有序 且 target在左边
                // nums[0] <= nums[mid]这里一定要用<=不能用<!!!，因为可能mid==0
            } else if (nums[0] <= nums[mid] && target >= nums[0] && target <= nums[mid]) {
                high = mid - 1;
                //左边是有序 且 target不在左边(小于num[0]||大于nums[mid])
            } else if (nums[0] <= nums[mid]) {
                low = mid + 1;
                //右边有序，且target在右边
            } else if (target >= nums[mid] && target <= nums[high]) {
                low = mid + 1;
                //右边有序，且target在左边
            } else {
                high = mid - 1;
            }
        }
        return nums[low] == target ? low : -1;

    }

    public static void main(String[] args) {
        int[] nums = {3, 1};
        System.out.println(new RotateSearch_33().search(nums, 1));
    }
}
