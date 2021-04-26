package com.leetcode.algorithm.backtracking;

/**
 * @ ClassName IslandPerimeter
 * @ author lskyline
 * @ 2021/4/26 9:33
 * @ Version: 1.0
 */
public class IslandPerimeter {
    /*
     * 岛屿的周长
     * 1)深度优先遍历
     * 2）迭代
     */
    private int[][] d = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public int islandPerimeter(int[][] grid) {
        if (grid == null || grid[0] == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    return dfs(grid, i, j);
                }
            }
        }
        return 0;
    }

    public int islandPerimeter02(int[][] grid) {
        if (grid == null || grid[0] == null || grid.length == 0 || grid[0].length ==0) {
            return 0;
        }
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    int cnt = 0;
                    for (int k = 0; k < d.length; k++) {
                        int newX = i + d[k][0];
                        int newY = j + d[k][1];
                        if (newX < 0 || newX >= grid.length || newY < 0 || newY >= grid[0].length || grid[newX][newY] == 0) {
                            cnt += 1;
                        }
                    }
                    ans += cnt;
                }
            }
        }
        return ans;
    }

    private int dfs(int[][] grid, int r, int c) {
        if (!inArea(grid, r, c)) {
            return 1;
        }
        if (grid[r][c] == 0) {
            return 1;
        }
        if (grid[r][c] != 1) {
            return 0;
        }
        //将陆地标记为已经遍历,0 海洋，1 陆地，2 已遍历陆地
        grid[r][c] = 2;
        return dfs(grid, r + 1, c) + dfs(grid, r - 1, c) + dfs(grid, r, c + 1) + dfs(grid, r, c - 1);
    }

    private boolean inArea(int[][] grid, int r, int c) {
        return r >= 0 && r < grid.length && c >= 0 && c < grid[0].length;
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{{0, 1, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {1, 1, 0, 0}};
        IslandPerimeter obj = new IslandPerimeter();
        int res = obj.islandPerimeter02(arr);
        System.out.println(res);
    }
}
