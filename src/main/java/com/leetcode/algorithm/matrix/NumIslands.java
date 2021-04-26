package com.leetcode.algorithm.matrix;

/**
 * @ ClassName NumIslands
 * @ author lskyline
 * @ 2021/4/26 23:10
 * @ Version: 1.0
 */
public class NumIslands {
    /*
     * 岛屿数量
     * 1) 深度优先遍历
     *
     */
    private int[][] d = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public int numIslands(char[][] grid) {
        if (grid == null || grid[0] == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int res = 0;
        boolean[][] visit = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1' && !visit[i][j]) {
                    findIsLand(grid, i, j, visit);
                    res++;
                }
            }
        }
        return res;
    }


    private void findIsLand(char[][] grid, int row, int col, boolean[][] visit) {
        if (grid[row][col] == '0' || visit[row][col]) {
            return ;
        }
        visit[row][col] = true;
        for (int i = 0; i < d.length; i++) {
            int newX = row + d[i][0];
            int newY = col + d[i][1];
            if (newX >= 0 && newX < grid.length && newY >= 0 && newY < grid[0].length && !visit[newX][newY]) {
                findIsLand(grid, newX, newY, visit);
            }
        }
    }

    public int numIslands02(char[][] grid) {
        if (grid == null || grid[0] == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i ,j);
                    res++;
                }
            }
        }
        return res;
    }


    private void dfs(char[][] grid, int row, int col) {
        if (!inArea(grid, row, col)) {
            return ;
        }
        if (grid[row][col] != '1') {
            return ;
        }
        grid[row][col] = '2';
        dfs(grid, row, col - 1);
        dfs(grid, row , col + 1);
        dfs(grid, row - 1, col);
        dfs(grid, row + 1, col);

    }

    private boolean inArea(char[][] grid, int row, int col) {
        return row >= 0 && row < grid.length && col >= 0 && col < grid[0].length;
    }

    private void dfs(char[] grid, int row, int col) {

    }

    public static void main(String[] args) {
        char[][] island = new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        NumIslands obj = new NumIslands();
        int res = obj.numIslands(island);
        System.out.println(res);
    }
}
