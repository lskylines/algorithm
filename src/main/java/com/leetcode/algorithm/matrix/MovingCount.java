package com.leetcode.algorithm.matrix;

/**
 * @ ClassName MovingCount
 * @ author lskyline
 * @ 2021/4/19 17:00
 * @ Version: 1.0
 */
public class MovingCount {
    private boolean[][] visit;
    public int movingCount(int m, int n, int k) {
        visit = new boolean[m][n];
        return dfs(0, 0, m, n, k);
    }
    public int dfs(int x,int y, int m, int n, int k) {
        if (x >= m || y >= n || x <0 || y < 0 || visit[x][y] || (x/10+x%10+y/10+y%10) > k) {
            return 0;
        }
        visit[x][y] = true;
        return dfs(x+1, y, m, n, k)  + dfs(x-1, y, m, n, k) + dfs(x, y+1, m, n, k) + dfs(x, y-1, m, n, k) + 1;
    }



    public static void main(String[] args) {
        MovingCount obj = new MovingCount();
        int res = obj.movingCount(2, 3,1);
        System.out.println(res);
    }

}
