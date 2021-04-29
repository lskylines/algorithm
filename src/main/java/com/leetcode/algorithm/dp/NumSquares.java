package com.leetcode.algorithm.dp;

import java.util.Arrays;

/**
 * @ ClassName NumSquares
 * @ author lskyline
 * @ 2021/4/27 20:36
 * @ Version: 1.0
 */
public class NumSquares {
    /*
     * 完全平方数
     * 1) 动态规划
     */
    public int numSquares(int n) {
        if (n <= 0) {
            return 0;
        }
        int[] dp = new int[n + 1];
        Arrays.fill(dp, n + 1);
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <=  i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[n] > n ? -1 : dp[n];
    }
    public static void main(String[] args) {
        NumSquares obj = new NumSquares();
        int res = obj.numSquares(1);
        System.out.println(res);
    }
}
