package com.leetcode.algorithm.dp;

/**
 * @ ClassName Rob
 * @ author lskyline
 * @ 2021/4/22 16:28
 * @ Version: 1.0
 */
public class Rob {
    /*
     * 打家劫舍II
     */
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        int left = robHelper(nums, 0, nums.length -1);
        int right = robHelper(nums, 1, nums.length);
        return Math.max(left, right);
    }

    public int rob02(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int left = robHelper02(nums, 0, nums.length -1);
        int right = robHelper02(nums, 1, nums.length);
        return Math.max(left, right);
    }

    private int robHelper02(int[] nums, int start, int end) {
        int pre = 0;
        int last = nums[start];
        for (int i = start + 1; i < end; i++) {
            int temp = Math.max(pre, last);
            last = nums[i] + pre;
            pre = temp;
        }
        return Math.max(pre, last);
    }


    private int robHelper(int[] nums, int start, int end) {
        int len = end - start + 1;
        System.out.println("start=" + start + ", end=" + end + ", len=" + len);
        int[][] dp = new int[len][2];
        dp[0][0] = 0;
        dp[0][1] = nums[start];
        for (int i = start + 1; i < end; i++) {
            System.out.println("dp[i-1][0]=" + dp[i- start - 1][0] + ",   dp[i-1][1]" + dp[i- start -1][1]);
            dp[i - start][0] = Math.max(dp[i- start - 1][0], dp[i- start - 1][1]);
            dp[i - start][1] = nums[i] + dp[i- start - 1][0];

            System.out.println("i= " + (i - start) + ", [0]=" + dp[i - start][0]);
            System.out.println("i= " + (i - start) + ", [1]=" + dp[i - start][1]);
        }
        return Math.max(dp[len-2][0], dp[len-2][1]);
    }

    public static void main(String[] args) {
        Rob obj = new Rob();
        int[] nums = new int[]{2, 3, 2};
        obj.rob(nums);
    }
}
