package com.ruanxinxin.mvc01.algorithm;

import java.util.HashMap;
import java.util.Map;

public class TwoNumberSum {


    /**时间复杂度：O(n)，
     我们只遍历了包含有 nn 个元素的列表一次。在表中进行的每次查找只花费 O(1) 的时间。

     空间复杂度：O(n)，
     所需的额外空间取决于哈希表中存储的元素数量，该表最多需要存储 n个元素。
     * @param arr
     * @param sum
     * @return
     */
    static int[] solution(int[] arr, int sum) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int value = arr[i];

            if (map.containsKey(sum - value)) {
                return new int[]{i, map.get(sum - value)};
            } else {
                map.put(value, i);
            }
        }
        throw new RuntimeException();
    }

    public static void main(String[] args) {
        int[] arr = {40, 2, 30, 9, 3, 7};
        int[] result=solution(arr,9);
        System.out.println(result);

    }

}
