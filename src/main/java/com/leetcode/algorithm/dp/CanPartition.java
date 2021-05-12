package com.leetcode.algorithm.dp;

/**
 * @ ClassName CanPartition
 * @ author lskyline
 * @ 2021/4/29 12:14
 * @ Version: 1.0
 */
public class CanPartition {
    /**
     * 分割等和子集
     * 1) 二维数组动态规划
     * 2） 一维数组动态规划
     */
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        // 特判：如果是奇数，就不符合要求
        if ((sum & 1) == 1) {
            return false;
        }
        int target = sum / 2;
        int[][] dp = new int[nums.length + 1][target + 1];
        for (int i = 1; i <= nums.length; i++) {
            for (int j = 1; j <= target; j++) {
                if (j >= nums[i -1]) {
                    dp[i][j] = Math.max(dp[i -1][j], dp[i - 1][j - nums[i -1]] + nums[i - 1]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[nums.length][target] == target;
    }

    public boolean canPartition02(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if ((sum & 1) == 1) {
            return false;
        }
        int target = sum / 2;
        int[] dp = new int[target + 1];
        //一维数组需要进行重量从大到小
        for (int i = 1; i <= nums.length; i++) {
            for (int j = target; j >= nums[i -1] ; j--) {
                dp[j] = Math.max(dp[j], dp[j - nums[i -1]] + nums[i -1]);
            }
        }
        return dp[target] == target;
    }


    public void printMatrix(boolean[][] t) {
        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t[0].length; j++) {
                System.out.print(t[i][j] + "| ");
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 5};
        CanPartition obj = new CanPartition();
        boolean flag = obj.canPartition02(arr);
        System.out.println(flag);
    }
}