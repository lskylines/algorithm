package com.leetcode.algorithm.dp;

/**
 * @ ClassName RobHelper
 * @ author lskyline
 * @ 2021/4/22 15:49
 * @ Version: 1.0
 */
public class RobHelper {
    /*
     * 打家劫舍
     */
    public int robHelper(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int length = nums.length;
        int[][] dp = new int[length][2];
        dp[0][0] = 0;
        dp[0][1] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);
            dp[i][1] = nums[i] + dp[i-1][0];
        }
        return Math.max(dp[length -1][0], dp[length -1][1]);
    }
}
