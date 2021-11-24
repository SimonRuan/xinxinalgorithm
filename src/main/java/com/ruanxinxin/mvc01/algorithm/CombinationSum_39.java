package com.ruanxinxin.mvc01.algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的数字可以无限制重复被选取。
 * 说明：
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1：
 * <p>
 * 输入：candidates = [2,3,6,7], target = 7,
 * 所求解集为：
 * [
 * [7],
 * [2,2,3]
 * ]
 * 示例 2：
 * <p>
 * 输入：candidates = [2,3,5], target = 8,
 * 所求解集为：
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 */
public class CombinationSum_39 {

    List<List<Integer>> resultList = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        //特殊情况
        if (candidates == null || candidates.length == 0) {
            return resultList;
        }

        dfs(candidates, 0, new LinkedList<>(), target);
        return resultList;
    }

    void dfs(int[] candidates, int index, LinkedList<Integer> merged, int currentTarget) {
        if (currentTarget == 0) {
            resultList.add(new ArrayList<>(merged));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (candidates[i] <= currentTarget) {
                merged.push(candidates[i]);
                dfs(candidates, i, merged, currentTarget - candidates[i]);
                merged.pop();
            }
        }
    }

    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        List<List<Integer>> resultList = new CombinationSum_39().combinationSum(candidates, 7);
        System.out.println(resultList);
    }
}
