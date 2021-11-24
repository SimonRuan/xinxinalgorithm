package com.ruanxinxin.mvc01.algorithm;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 在一个 N × N 的方形网格中，每个单元格有两种状态：空（0）或者阻塞（1）。
 * <p>
 * 一条从左上角到右下角、长度为 k 的畅通路径，由满足下述条件的单元格 C_1, C_2, ..., C_k 组成：
 * <p>
 * 相邻单元格 C_i 和 C_{i+1} 在八个方向之一上连通（此时，C_i 和 C_{i+1} 不同且共享边或角）
 * C_1 位于 (0, 0)（即，值为 grid[0][0]）
 * C_k 位于 (N-1, N-1)（即，值为 grid[N-1][N-1]）
 * 如果 C_i 位于 (r, c)，则 grid[r][c] 为空（即，grid[r][c] == 0）
 * 返回这条从左上角到右下角的最短畅通路径的长度。如果不存在这样的路径，返回 -1 。
 * <p>
 * 提示：
 * <p>
 * 1 <= grid.length == grid[0].length <= 100
 * grid[i][j] 为 0 或 1
 */
public class ShortestPathBinaryMatrix_1091 {

    public int shortestPathBinaryMatrix(int[][] grid) {
        /*
        // 定义队列  queue
        //定义已访问集合 visited
        //初始节点放入队列 queue.add(init)
        //对列不为空时遍历
        while( queue is not empty){
            //获取所有节点
            nodes = queue.getAll();
            for(node in nodes){
                // 判断是否到达终点位置
                if(end){
                   return;
            }
            newNodes = process(temp);
            //剪枝
            filter(newNodes);
            queue.addAll(newNodes);
       }
               */
        if (grid.length == 1 && grid[0].length == 1) {
            return grid[0][0] == 0 ? 1 : -1;
        }
        int row = grid.length;
        int col = grid[0].length;
        if (grid[0][0] == 1 || grid[row - 1][col - 1] == 1) {
            return -1;
        }
        int[][] visited = new int[row][col];
        int[][] directions = {{1, 1}, {1, 0}, {1, -1}, {0, 1}, {0, -1}, {-1, 1}, {-1, 0}, {-1, -1}};
        int length = 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        while (!queue.isEmpty()) {
            Queue<int[]> newQueue = new LinkedList<>();
            while (!queue.isEmpty()) {
                int[] item = queue.poll();
                for (int i = 0; i < 8; i++) {
                    int newX = item[0] + directions[i][0];
                    int newY = item[1] + directions[i][1];
                    if (newX == row - 1 && newY == col - 1) {
                        return length + 1;
                    }
                    if (inGrid(row, col, newX, newY) && grid[newX][newY] == 0 && visited[newX][newY] == 0) {
                        visited[newX][newY] = 1;
                        newQueue.offer(new int[]{newX, newY});
                    }
                }
            }
            length++;
            queue = newQueue;
        }
        return -1;
    }


    boolean inGrid(int row, int col, int x, int y) {
        return x >= 0 && x < row && y >= 0 && y < col;
    }

    public static void main(String[] args) {
        //[[0,0,0,0,1],[1,0,0,0,0],[0,1,0,1,0],[0,0,0,1,1],[0,0,0,1,0]]
        int[][] grid = new int[5][5];
        grid[0] = new int[]{0, 0, 0, 0, 1};
        grid[1] = new int[]{1, 0, 0, 0, 0};
        grid[2] = new int[]{0, 1, 0, 1, 0};
        grid[3] = new int[]{0, 0, 0, 1, 1};
        grid[4] = new int[]{0, 0, 0, 1, 0};

        System.out.println(new ShortestPathBinaryMatrix_1091().shortestPathBinaryMatrix(grid));
    }
}
