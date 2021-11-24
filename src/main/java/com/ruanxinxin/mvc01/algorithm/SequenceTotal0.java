package com.ruanxinxin.mvc01.algorithm;

public class SequenceTotal0 {

    public int solution(int[] array) {

        int length = array.length;
        //corner case
        if (length >= 10000) {
            return -1;
        }

        //定义一个长度也为length的result数组
        int[] result = new int[length];

        //初始值
        result[0] = array[0] == 0 ? 1 : 0;

        //动态递归
        for (int currentIndex = 1; currentIndex < length; currentIndex++) {
            result[currentIndex] = 0;
            for (int i = 0; i <= currentIndex; i++) {
                int j = i;
                int tempSum = 0;
                while (j <= currentIndex) {
                    tempSum += array[j];
                    j++;
                }
                if (tempSum == 0) {
                    result[currentIndex]++;
                }
            }
            result[currentIndex] += result[currentIndex - 1];
        }
        return result[length - 1];
    }


    public static void main(String[] args) {
        int[] array = new int[]{2, -2, 3, 0, 4, -7};


        System.out.println(new SequenceTotal0().solution(array));
    }

}
