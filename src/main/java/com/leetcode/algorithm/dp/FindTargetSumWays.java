package com.leetcode.algorithm.dp;

/**
 * @ ClassName FindTargetSumWays
 * @ author lskyline
 * @ 2021/4/29 16:54
 * @ Version: 1.0
 */
public class FindTargetSumWays {
    /*
     *  目标和
     * 1)暴力法
     * 2)动态规划
     */
    private int count = 0;
    public int findTargetSumWays(int[] nums, int target) {
        calculate(nums, 0, 0, target);
        return count;
    }

    public int findTargetSumWays02(int[] nums, int S) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (S > sum || (S + sum) % 2 == 1) {
            return 0;
        }
        int target = (S  + sum) / 2;
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = target; j >= nums[i]; j--) {
                dp[j] = dp[j] + dp[j - nums[i]];
            }
        }
        return dp[target];
    }

    private void calculate(int[] nums, int target, int index, int S) {
        if (index == nums.length) {
            if (target == S) {
                count++;
            }
        } else {
            calculate(nums, target + nums[index], index + 1, S);
            calculate(nums, target - nums[index], index + 1, S);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1, 1, 1};
        int S = 3;
        FindTargetSumWays obj = new FindTargetSumWays();
        int res = obj.findTargetSumWays(nums, S);
        System.out.println(res);
    }
}
