package com.ruanxinxin.mvc01.algorithm;

/**
 * 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * <p>
 * 说明：每次只能向下或者向右移动一步。
 */
public class MinPathSum_64 {

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m + 1][n + 1];
        for (int row = 1; row < m + 1; row++) {
            for (int col = 1; col < n + 1; col++) {
                if (row == 1) {
                    dp[1][col] = grid[0][col - 1] + dp[1][col - 1];
                } else if (col == 1) {
                    dp[row][1] = grid[row - 1][0] + dp[row - 1][1];
                } else {
                    dp[row][col] = grid[row - 1][col - 1] + Math.min(dp[row - 1][col], dp[row][col - 1]);
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        int[][] grid = new int[2][2];
        grid[0] = new int[]{1, 2};
        grid[1] = new int[]{1, 1};


        System.out.println(new MinPathSum_64().minPathSum(grid));
    }

}
