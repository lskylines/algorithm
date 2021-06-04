package com.leetcode.algorithm.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @ ClassName UniquePaths
 * @ author lskyline
 * @ 2021/5/14 9:15
 * @ Version: 1.0
 */
public class UniquePaths {
    /*
     * 不同路径
     * 1)  递归 + 记忆化
     * 2） 二维数组DP
     * 3） 一维数组DP
     */
    private Map<String, Integer> map = new HashMap<>();
    public int uniquePaths0(int m, int n) {
        //从右下角可以往回进行递归
        int row=  m - 1;
        int col = n - 1;
        return pathHelp(row, col, m, n);
    }


    public int uniquePaths02(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m ; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = 1;
                } else if (i == 0) {
                    dp[i][j] = dp[i][j - 1];
                } else if(j == 0) {
                    dp[i][j] = dp[i -1][j];
                } else {
                    dp[i][j] = dp[i -1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    public int uniquePaths03(int m, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] += dp[j -1];
            }
        }
        return dp[n -1];
    }

    private int pathHelp(int row, int col, int m, int n) {
        if (row == 0 || col == 0) {
            return 1;
        } else {
            String key = row + "_" + col;
            if (map.containsKey(key)) {
                return map.get(key);
            }
            int res =  pathHelp(row -1, col , m, n) + pathHelp(row, col - 1, m, n);
            map.put(key, res);
            return res;
        }
    }

    public static void main(String[] args) {
        int m = 3;
        int n = 7;
        UniquePaths obj = new UniquePaths();
        int res = obj.uniquePaths02(m, n);
        System.out.println(res);
    }

}
