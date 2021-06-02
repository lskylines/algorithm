package com.leetcode.algorithm.dp;

/**
 * @ ClassName Change
 * @ author lskyline
 * @ 2021/6/3 0:05
 * @ Version: 1.0
 */
public class Change {
    /*
     * 零钱兑换 II
     * 1)动态规划
     */
    public int change(int amount, int[] coins) {
        if (coins == null || coins.length ==0 || amount < 0) {
            return -1;
        }
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int i = 1; i <= coins.length; i++) {
            //属于完全背包问题
            for (int j = 1; j <= amount; j++) {
                if (j >= coins[i - 1]) {
                    dp[j] += dp[j - coins[i -1]];
                }
            }
        }
        return dp[amount];
    }
}
