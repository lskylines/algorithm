package com.leetcode.algorithm.backtracking;

/**
 * @ ClassName MaxAreaOfIsland
 * @ author lskyline
 * @ 2021/5/1 15:10
 * @ Version: 1.0
 */
public class MaxAreaOfIsland {
    /*
     * 岛屿的最大面积
     * 1) DFS
     */
    private boolean[][] visit;
    private int[][] d = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid[0] == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        visit = new boolean[m][n];
        int maxArea = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    maxArea = Math.max(maxArea, getMaxArea(grid, i ,j, visit));
                }
            }
        }
        return maxArea;
    }

    private int getMaxArea(int[][] grid, int row, int col, boolean[][] visit) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || visit[row][col] || grid[row][col] == 0) {
            return 0;
        }
        visit[row][col] = true;
        int left = getMaxArea(grid, row, col - 1, visit);
        int right = getMaxArea(grid, row, col + 1, visit);
        int up = getMaxArea(grid, row -1, col, visit);
        int down = getMaxArea(grid, row + 1, col, visit);
        return 1 + left + right + up + down;
    }

    public static void main(String[] args) {
        int[][] grid = new int[][] {
                {0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0},
        };
        MaxAreaOfIsland obj = new MaxAreaOfIsland();
        int res = obj.maxAreaOfIsland(grid);
        System.out.println(res);
    }
}
