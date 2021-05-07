package com.leetcode.algorithm.dp;

import java.util.Arrays;

/**
 * @ ClassName FindLength
 * @ author lskyline
 * @ 2021/4/23 0:51
 * @ Version: 1.0
 */
public class FindLength {
    /*
     * 最长重复子数组
     * 1) 二维
     * 2）一维
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

    public int findLength02(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return 0;
        }
        int m =  nums1.length;
        int n = nums2.length;
        int[] dp = new int[m + 1];
        int maxValue = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = n; j >= 1 ; j--) {
                if (nums1[i-1] == nums2[j-1]) {
                    dp[j] = dp[j -1] + 1;
                } else {
                    dp[j] = 0;
                }
                maxValue = Math.max(maxValue, dp[j]);
            }
        }
        return maxValue;
    }

    public void printMatrix(int[] dp) {
        System.out.println("================================");
        System.out.println(Arrays.toString(dp));
        System.out.println("================================");
        System.out.println();
    }


    public void printMatrix(int[][] dp) {
        System.out.println("================================");
        for (int i = 0; i < dp.length; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }
        System.out.println("================================");
        System.out.println();
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 3, 2, 1};
        int[] nums2 = new int[]{3, 2, 1, 4, 7};
        FindLength obj = new FindLength();
        obj.findLength02(nums1, nums2);
    }
}
