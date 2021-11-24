package com.ruanxinxin.mvc01.algorithm;

/**
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 * 提示：
 * <p>
 * m == obstacleGrid.length
 * n == obstacleGrid[i].length
 * 1 <= m, n <= 100
 * obstacleGrid[i][j] 为 0 或 1
 */
public class UniquePathsWithObstacles_63 {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if (m == 1 && n == 1) {
            return 1 - obstacleGrid[0][0];
        }

        int[][] dp = new int[m + 1][n + 1];

        for (int i = m; i > 0; i--) {
            if (obstacleGrid[i - 1][n - 1] == 0) {
                dp[i][n] = 1;
            } else {
                break;
            }
        }

        for (int j = n; j > 0; j--) {
            if (obstacleGrid[m - 1][j - 1] == 0) {
                dp[m][j] = 1;
            } else {
                break;
            }
        }
        dp[m][n] = 0;

        for (int row = m - 1; row > 0; row--) {
            for (int col = n - 1; col > 0; col--) {
                if (obstacleGrid[row - 1][col - 1] == 0) {
                    dp[row][col] = dp[row + 1][col] + dp[row][col + 1];
                }
            }
        }
        return dp[1][1];
    }

    public static void main(String[] args) {
        System.out.println(new UniquePathsWithObstacles_63());
    }
}
