package com.ruanxinxin.algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 子集
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * 说明：解集不能包含重复的子集。
 * 示例:
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 * [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 */
public class SubSets_78 {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        if (nums.length == 0) {
            return res;
        }
        recurse(res, nums, new ArrayList<>(), 0);
        return res;
    }

    void recurse(List<List<Integer>> res, int[] nums, List<Integer> curr, int index) {
        if (index == nums.length) {
            res.add(new ArrayList<>(curr));
            return;   //这里不要漏了！！！
        }
        recurse(res, nums, curr, index + 1);
        curr.add(nums[index]);
        recurse(res, nums, curr, index + 1);
        curr.remove(curr.size() - 1);  //这里不要漏了！！！
    }


}
