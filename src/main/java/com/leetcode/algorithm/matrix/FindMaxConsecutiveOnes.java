package com.leetcode.algorithm.matrix;

/**
 * @ ClassName findMaxConsecutiveOnes
 * @ author lskyline
 * @ 2021/5/9 12:17
 * @ Version: 1.0
 */
public class FindMaxConsecutiveOnes {
    /*
     * 最大连续1的个数
     * 1) 动态规划
     *
     */
    public int findMaxConsecutiveOnes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length + 1];
        dp[0] = 0;
        int maxVal = 0;
        for (int i =1; i <= nums.length; i++) {
            dp[i] = nums[i-1] == 1 ? dp[i-1] + 1 : 0;
            maxVal = Math.max(maxVal, dp[i]);
        }
        return maxVal;
    }

    public int findMaxConsecutiveOnes02(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int count = 0;
        int maxCount = 0;
        for (int i = 0; i < nums.length; i++) {
            count = nums[i] == 0 ? 0 : count + 1;
            maxCount = Math.max(maxCount,  count);
        }
        return maxCount;
    }
}
