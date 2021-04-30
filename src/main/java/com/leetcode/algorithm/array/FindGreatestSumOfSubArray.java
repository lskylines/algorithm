package com.leetcode.algorithm.array;

/**
 * @ ClassName FindGreatestSumOfSubArray
 * @ author lskyline
 * @ 2021/4/14 17:11
 * @ Version: 1.0
 */
public class FindGreatestSumOfSubArray {
    /*
     * 连续子数组的最大和
     */
    public int findGreatestSumOfSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int cur = 0;
        for (int i = 0; i < nums.length; i++) {
            if (cur >= 0) {
                cur += nums[i];
            } else {
                cur = nums[i];
            }
            max = Math.max(max, cur);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 1, -2, 3, 10 ,-4, 7, 2, -5};
        FindGreatestSumOfSubArray obj = new FindGreatestSumOfSubArray();
        int target = obj.findGreatestSumOfSubArray(arr);
        System.out.println(target);
    }
}
