package com.ruanxinxin.mvc01.algorithm;

/**
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 * 问总共有多少条不同的路径？
 */
public class UniquePaths_62 {

    public int uniquePaths(int m, int n) {

        if (m == 1 || n == 1) {
            return 1;
        }
        int[][] dp = new int[m + 1][n + 1];
        dp[m - 1][n] = 1;
        dp[m][n - 1] = 1;
        for (int row = m; row > 0; row--) {
            for (int col = n; col > 0; col--) {
                if (row != m || col != n) {
                    if (row == m) {
                        dp[row][col] = 1;
                    } else if (col == n) {
                        dp[row][col] = 1;
                    } else {
                        dp[row][col] = ((row + 1 > m) ? 0 : dp[row + 1][col])
                                + ((col + 1 > n) ? 0 : dp[row][col + 1]);
                    }
                }

            }
        }
        return dp[1][1];
    }

    public static void main(String[] args) {
        System.out.println(new UniquePaths_62().uniquePaths(3, 7));
    }
}
