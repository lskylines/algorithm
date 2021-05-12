package com.leetcode.algorithm.dp;

/**
 * @ ClassName LastStoneWeightII
 * @ author lskyline
 * @ 2021/5/12 23:42
 * @ Version: 1.0
 */
public class LastStoneWeightII {
    /**
     * 最后一块石头的重量 II
     * 1) 二维数组动态规划
     * 2） 一维数组动态规划
     */
    public int lastStoneWeightII(int[] stones) {
        if (stones == null || stones.length == 0) {
            return 0;
        }
        int sum = 0;
        for (int i = 0 ; i < stones.length; i++) {
            sum += stones[i];
        }
        int target = sum / 2;
        int[][] dp = new int[stones.length + 1][target + 1];
        for (int i = 1; i <= stones.length; i++) {
            for (int j = 1; j <= target; j++) {
                if (j >= stones[i -1]) {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j - stones[i -1]] + stones[i -1]);
                } else {
                    dp[i][j] = dp[i -1][j];
                }
            }
        }
        return (sum - dp[stones.length][target]) - dp[stones.length][target];
    }

    public int lastStoneWeightII02(int[] stones) {
        if (stones == null || stones.length == 0) {
            return 0;
        }
        int sum = 0;
        for (int i = 0 ; i < stones.length; i++) {
            sum += stones[i];
        }
        int target = sum / 2;
        int[] dp = new int[target + 1];
        for (int i = 0; i < stones.length; i++) {
            for (int j = target; j >= stones[i] ; j--) {
                dp[j] = Math.max(dp[j], dp[j - stones[i]] + stones[i]);
            }
        }
        return sum - dp[target] - dp[target];
    }
}
