package com.leetcode.algorithm.dp;

/**
 * @ ClassName LengthOfLIS
 * @ author lskyline
 * @ 2021/4/22 23:53
 * @ Version: 1.0
 */
public class LengthOfLIS {
    /*
     * 最长递增子序列
     */
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        int[] dp = new int[nums.length];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = 1;
        }
        int max = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = i-1; j >= 0 ; j--) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    max = Math.max(max, dp[i]);
                }
            }
        }
        return max;
    }
}
