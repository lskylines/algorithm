package com.leetcode.algorithm.array;

import java.util.Arrays;

/**
 * @ ClassName MaxProduct
 * @ author lskyline
 * @ 2021/4/26 22:12
 * @ Version: 1.0
 */
public class MaxProduct {
    /*
     * 乘积最大子数组 M
     */
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] maxF = new int[nums.length];
        int[] minF = new int[nums.length];
        maxF[0] = nums[0];
        minF[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            maxF[i] = Math.max(maxF[i-1] * nums[i], Math.max(nums[i], minF[i-1] * nums[i]));
            minF[i] = Math.min(minF[i-1] * nums[i], Math.min(nums[i], maxF[i-1] * nums[i]));
        }

        int maxValue = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            maxValue = Math.max(maxF[i], maxValue);
        }

        return maxValue;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{-2, 0, 4};
        MaxProduct obj = new MaxProduct();
        int res = obj.maxProduct(arr);
        System.out.println(res);
    }
}
