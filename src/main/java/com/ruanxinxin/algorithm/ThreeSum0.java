package com.ruanxinxin.algorithm;

import java.util.*;

public class ThreeSum0 {

    static List<List<Integer>> solution(int[] arr) {

        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(arr);   //将arr从小到大排序

        int init, left = 1, right = arr.length - 1;

        for (init = 0; init < arr.length - 1; init++) {

            if (arr[init] > 0) break;
            if (arr[init] == arr[init + 1]) continue;

            left = init + 1;
            while (left < right) {

                int sum = arr[init] + arr[left] + arr[right];
                if (sum == 0) {
                    result.add(Arrays.asList(arr[init], arr[left], arr[right]));

                    while (left < right && arr[left + 1] == arr[left]) left++;
                    while (left < right && arr[right - 1] == arr[right]) right--;

                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {5, -2, 4, 1, 1, 0, -1};
        List<List<Integer>> result = solution(arr);
        System.out.println(result);
    }

}
