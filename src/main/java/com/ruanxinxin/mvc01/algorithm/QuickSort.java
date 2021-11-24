package com.ruanxinxin.mvc01.algorithm;

public class QuickSort {

//    static void quickSort(int[] arr, int start, int end) {
//
//        if (start > end) {
//            return;
//        }
//
//        int left = start, right = end, head = arr[start];
//
//        while (left < right) {
//            //从右往左找到第一个小于哨兵的值
//            while (arr[right] >= head && left < right) {
//                right--;
//            }
//            //从左往右找到第一个大于哨兵的值
//            while (arr[left] <= head && left < right) {
//                left++;
//            }
//            //交换
//            if (left < right) {
//                int t = arr[left];
//                arr[left] = arr[right];
//                arr[right] = t;
//            }
//        }
//
//        //交换哨兵与left位置的值（此时left=right）
//        arr[start] = arr[left];
//        arr[left] = head;
//
//        //分别对左半段和右半段排序
//        quickSort(arr, start, left - 1);
//        quickSort(arr, left + 1, end);
//    }
//
//
//    public static void main(String[] args) {
//        int[] arr = {34, 4, 6, 7, 32, 56, 21, 8, 99, 23, 34, 56, 42, 89};
//        quickSort(arr, 0, arr.length - 1);
//        System.out.println(arr);
//    }

}
