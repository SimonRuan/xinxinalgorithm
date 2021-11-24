package com.ruanxinxin.mvc01.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * <p>
 * candidates 中的每个数字在每个组合中只能使用一次。
 * <p>
 * 说明：
 * <p>
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 * <p>
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 所求解集为:
 * [
 * [1, 7],
 * [1, 2, 5],
 * [2, 6],
 * [1, 1, 6]
 * ]
 * 示例 2:
 * <p>
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 所求解集为:
 * [
 *   [1,2,2],
 *   [5]
 * ]
 */
public class CombinationSumII_40 {

    List<List<Integer>> resultList = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        //特殊情况
        if (candidates == null || candidates.length == 0) {
            return resultList;
        }
        //关键步骤
        Arrays.sort(candidates);
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
                //关键步骤 同一层相同数值的结点，从第 2 个开始，候选数更少，结果一定发生重复，因此跳过，用 continue
                if (i > index && candidates[i] == candidates[i - 1]) {
                    continue;
                }
                merged.addLast(candidates[i]);
                dfs(candidates, i + 1, merged, currentTarget - candidates[i]);
                merged.removeLast();
            }
        }
    }

    public static void main(String[] args) {
        int[] candidates = {10, 1, 2, 7, 6, 1, 5, 100};
        List<List<Integer>> resultList = new CombinationSumII_40().combinationSum2(candidates, 8);
        System.out.println(resultList);
    }
}
