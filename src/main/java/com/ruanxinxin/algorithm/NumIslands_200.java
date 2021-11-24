package com.ruanxinxin.algorithm;

/**
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 * <p>
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 * <p>
 * 此外，你可以假设该网格的四条边均被水包围。
 * <p>
 * 示例 1：
 * <p>
 * 输入：grid = [
 * ['1','1','1','1','0'],
 * ['1','1','0','1','0'],
 * ['1','1','0','0','0'],
 * ['0','0','0','0','0']
 * ]
 * 输出：1
 * 示例 2：
 * <p>
 * 输入：grid = [
 * ['1','1','0','0','0'],
 * ['1','1','0','0','0'],
 * ['0','0','1','0','0'],
 * ['0','0','0','1','1']
 * ]
 * 输出：3
 *  
 * <p>
 * 提示：
 * <p>
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 300
 * grid[i][j] 的值为 '0' 或 '1'
 */
public class NumIslands_200 {

    //是否遍历过
    private boolean[][] visited;
    //方向
    private int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    //长，宽
    private int m, n;
    //岛屿数量
    private int count = 0;


    public int numIslands(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int i, int j) {
        visited[i][j] = true;
        for (int[] direction : directions) {
            int newI = i + direction[0];
            int newJ = j + direction[1];
            if (inArea(newI, newJ) && grid[newI][newJ] == '1' && !visited[newI][newJ]) {
                dfs(grid, newI, newJ);
            }
        }
    }

    //i、j坐标有效
    private boolean inArea(int i, int j) {
        return 0 <= i && i < m && 0 <= j && j < n;
    }

    public static void main(String[] args) {
        char[][] grid = {{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}};
        System.out.println(new NumIslands_200().numIslands(grid));
    }

}
