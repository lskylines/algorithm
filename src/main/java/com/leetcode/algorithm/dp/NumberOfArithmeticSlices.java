package com.leetcode.algorithm.dp;

import java.util.Arrays;

/**
 * @ ClassName NumberOfArithmeticSlices
 * @ author lskyline
 * @ 2021/5/4 12:01
 * @ Version: 1.0
 */
public class NumberOfArithmeticSlices {
    /*
     * 等差数列划分
     * 1) 暴力法
     * 2) 动态规划
     */
    public int numberOfArithmeticSlices(int[] nums) {
        int len = nums.length;
        if (len < 3) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            int d =  nums[i + 1] - nums[i];
            for (int j = i + 2; j < nums.length; j++) {
                if (nums[j] - nums[j-1] == d) {
                    count++;
                } else {
                    break ;
                }
            }
        }
        return count;
    }
    
    public int numberOfArithmeticSlices02(int[] nums) {
        int len = nums.length;
        if (len < 3) {
            return 0;
        }
        int[] dp = new int[nums.length + 1];
        int sum = 0;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] - nums[i-1] == nums[i - 1] - nums[i-2]) {
                dp[i] = dp[i - 1] + 1;
                sum += dp[i];
            }
        }
        System.out.println(Arrays.toString(dp));
        return sum;
    }

    public static void main(String[] args) {
        NumberOfArithmeticSlices obj = new NumberOfArithmeticSlices();
        int[] nums = new int[]{1, 2, 3, 4};
        int res = obj.numberOfArithmeticSlices(nums);
        System.out.println(res);
    }
}

