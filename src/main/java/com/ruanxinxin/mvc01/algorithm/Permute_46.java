package com.ruanxinxin.mvc01.algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,2,3]
 * 输出:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 */
public class Permute_46 {

    List<List<Integer>> resultList = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length < 1) {
            return resultList;
        }
        if (nums.length == 1) {
            resultList.add(Collections.singletonList(nums[0]));
            return resultList;
        }

        boolean[] used = new boolean[10];
        LinkedList<Integer> current = new LinkedList<>();
        solution(nums, used, current);


        return resultList;
    }

    public void solution(int[] nums, boolean[] used, LinkedList<Integer> current) {
        if (current.size() == nums.length) {
            resultList.add(new ArrayList<>(current));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                current.addLast(nums[i]);
                used[i]=true;
                solution(nums, used, current);
                current.removeLast();
                used[i]=false;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums={1,2,3};
        List<List<Integer>> resultList=new Permute_46().permute(nums);
        System.out.println(resultList);
    }
}
