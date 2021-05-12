package com.leetcode.algorithm.dp;

/**
 * @ ClassName NumArray
 * @ author lskyline
 * @ 2021/5/12 11:12
 * @ Version: 1.0
 */
public class NumArray {
    /*
     *  区域和检索 - 数组不可变
     */
    private int[] dp;
    public NumArray(int[] nums) {
        dp = new int[nums.length + 1];
        for (int i = 1; i <= nums.length; i++) {
            dp[i] = dp[i-1] + nums[i-1];
        }
    }

    public int sumRange(int left, int right) {
        return dp[right + 1] - dp[left];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-2, 0, 3, -5, 2, -2};
        NumArray obj = new NumArray(nums);
        int res = obj.sumRange(2, 5);
        System.out.println(res);
    }
}
