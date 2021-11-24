package com.ruanxinxin.algorithm;

public class RemoveDuplicates {

    static int solution(int[] arr) {
        if (arr.length == 0) return 0;

        int i = 0;
        for (int j = 1; j < arr.length; j++) {
            if (arr[i] != arr[j]) {
                i++;
                arr[i] = arr[j];
            }
        }
        return i + 1;
    }


    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 3, 4, 4, 4, 5, 6, 6};
        int result = solution(arr);
        System.out.println(result);
    }
}
