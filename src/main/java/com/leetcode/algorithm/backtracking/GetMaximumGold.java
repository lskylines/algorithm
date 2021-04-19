package com.leetcode.algorithm.backtracking;

/**
 * @ ClassName GetMaximumGold
 * @ author lskyline
 * @ 2021/4/20 0:47
 * @ Version: 1.0
 */
public class GetMaximumGold {
    /*
     *  黄金矿工
     */
    public int getMaximumGold(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        //保存最大值
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                res = Math.max(res, dfs(grid, i, j));
                System.out.println("i=" + i + ", y=" + j);
            }
        }
        return res;
    }

    private int dfs(int[][] grid, int x, int y) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == 0) {
            return 0;
        }
        int temp = grid[x][y];
        System.out.println("初始X：" + x + " ============= Y:" + y);
        grid[x][y] = 0;
        int up = dfs(grid, x - 1, y);
        int down = dfs(grid, x + 1, y);
        int left = dfs(grid, x, y - 1);
        int right = dfs(grid, x, y + 1);
        System.out.println("up:" + up + ",down:" + down + ",left:" + left + ", right:" + right);
        int max = Math.max(left, Math.max(right, Math.max(up, down)));
        grid[x][y] = temp;
        return max + grid[x][y];

    }

    public static void main(String[] args) {
        GetMaximumGold obj = new GetMaximumGold();
        int[][] arr = new int[][]{{0, 6, 0}, {5, 8, 7}, {0, 9, 0}};
        int res = obj.getMaximumGold(arr);
        System.out.println(res);
    }
}
