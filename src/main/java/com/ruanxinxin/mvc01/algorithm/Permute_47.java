package com.ruanxinxin.mvc01.algorithm;

import java.util.*;

/**
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 * 示例 1：
 * <p>
 * 输入：nums = [1,1,2]
 * 输出：
 * [[1,1,2],
 * [1,2,1],
 * [2,1,1]]
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 *  
 * 提示：
 * <p>
 * 1 <= nums.length <= 8
 * -10 <= nums[i] <= 10
 */
public class Permute_47 {

    List<List<Integer>> resultList = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null || nums.length < 1) {
            return resultList;
        }
        if (nums.length == 1) {
            resultList.add(Collections.singletonList(nums[0]));
            return resultList;
        }
        Arrays.sort(nums);
        boolean[] used = new boolean[10];
        Deque<Integer> current = new ArrayDeque<>(nums.length);
        solution(nums, used, current);


        return resultList;
    }

    public void solution(int[] nums, boolean[] used, Deque<Integer> current) {
        if (current.size() == nums.length) {
            resultList.add(new ArrayList<>(current));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            if (!used[i]) {
                current.addLast(nums[i]);
                used[i] = true;
                solution(nums, used, current);
                current.removeLast();
                used[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 1};
        List<List<Integer>> resultList = new Permute_47().permuteUnique(nums);
        System.out.println(resultList);
    }
}
