package com.ruanxinxin.mvc01.algorithm;

/**
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 */
public class MaxArea {

    //时间复杂度O(n)，空间复杂度O(1)
    static int solution(int[] arr) {

        int result = 0, left = 0, right = arr.length - 1;

        while (left < right) {

            int area = (right - left) * Math.min(arr[left], arr[right]);
            result = Math.max(result, area);
            if (arr[left] < arr[right]) {
                left++;
            } else {
                right--;
            }
        }
        return result;
    }


    public static void main(String[] args) {
        int[] arr = {100, 8, 6, 2, 5, 4, 8, 3, 7, 55, 64, 32, 434, 54, 6, 75, 3, 99};
        int result = solution(arr);
        System.out.println(result);
    }

}
