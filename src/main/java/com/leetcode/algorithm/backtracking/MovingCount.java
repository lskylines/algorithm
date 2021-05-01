package com.leetcode.algorithm.backtracking;

/**
 * @ ClassName MovingCount
 * @ author lskyline
 * @ 2021/5/1 14:53
 * @ Version: 1.0
 */
public class MovingCount {
    /*
     * 机器人运动范围
     */
    private boolean[][] visit;
    public int movingCount(int m, int n, int k) {
        visit = new boolean[m][n];
        return dfs(0, 0, m, n, k);
    }

    private int dfs(int x, int y, int m, int n, int k) {
        if (x >= m || y >= n || x < 0 || y < 0 || visit[x][y] || sum(x, y) > k) {
            return 0;
        }
        return 1 + dfs(x + 1, y, m, n, k) + dfs(x, y + 1, m, n, k);
    }

    private int sum(int x, int y) {
        int sum = 0;
        while (x != 0) {
            sum += x % 10;
            x /= 10;
        }
        while (y != 0) {
            sum += y % 10;
            y /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        int m = 2;
        int n = 3;
        int k = 1;
        MovingCount obj = new MovingCount();
        int res = obj.movingCount(m, n, k);
        System.out.println(res);
    }
}
