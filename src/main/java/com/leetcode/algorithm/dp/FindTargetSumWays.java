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
     * 2)动态规划  TODO
     */
    private int count = 0;
    public int findTargetSumWays(int[] nums, int target) {
        calculate(nums, 0, 0, target);
        return count;
    }

    public int findTargetSumWays02(int[] nums, int target) {
        return 0;
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
