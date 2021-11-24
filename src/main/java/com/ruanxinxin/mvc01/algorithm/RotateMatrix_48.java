package com.ruanxinxin.mvc01.algorithm;

/**
 * 给定一个 n × n 的二维矩阵表示一个图像。
 * <p>
 * 将图像顺时针旋转 90 度。
 * <p>
 * 说明：
 * <p>
 * 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
 * <p>
 * 示例 1:
 * <p>
 * 给定 matrix =
 * [
 * [1,2,3],
 * [4,5,6],
 * [7,8,9]
 * ],
 * <p>
 * 原地旋转输入矩阵，使其变为:
 * [
 * [7,4,1],
 * [8,5,2],
 * [9,6,3]
 * ]
 * 示例 2:
 * <p>
 * 给定 matrix =
 * [
 * [ 5, 1, 9,11],
 * [ 2, 4, 8,10],
 * [13, 3, 6, 7],
 * [15,14,12,16]
 * ],
 * <p>
 * 原地旋转输入矩阵，使其变为:
 * [
 * [15,13, 2, 5],
 * [14, 3, 4, 1],
 * [12, 6, 8, 9],
 * [16, 7,10,11]
 * ]
 */
public class RotateMatrix_48 {

    public void rotate(int[][] matrix) {

        if (matrix == null || matrix.length == 0) {
            return;
        }
        int n = matrix.length;
        for (int row = 0; row < n; row++) {
            for (int column = 0; column <= row; column++) {
                int temp = matrix[column][row];
                matrix[column][row] = matrix[row][column];
                matrix[row][column] = temp;
            }
        }
        //翻转每一行
        for (int row = 0; row < n; row++) {
            for (int column = 0; column < n / 2; column++) {
                int temp = matrix[row][column];
                matrix[row][column] = matrix[row][n - column - 1];
                matrix[row][n - column - 1] = temp;
            }
        }

        System.out.println(matrix);
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2}, {3, 4}};
        new RotateMatrix_48().rotate(matrix);
    }
}
