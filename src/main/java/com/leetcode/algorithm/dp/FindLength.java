package com.leetcode.algorithm.dp;

/**
 * @ ClassName FindLength
 * @ author lskyline
 * @ 2021/4/23 0:51
 * @ Version: 1.0
 */
public class FindLength {
    /*
     * 最长重复子数组
     */
    public int findLength(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return 0;
        }
        int m =  nums1.length;
        int n = nums2.length;
        int[][] dp = new int[m + 1][n + 1];
        int maxValue = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i-1][j-1]  + 1;
                } else {
                    dp[i][j] = 0;
                }
                maxValue = Math.max(maxValue, dp[i][j]);
            }
        }
        return maxValue;
    }
}
