package com.leetcode.algorithm.dp;

/**
 * @ ClassName MaxLong
 * @ author lskyline
 * @ 2021/5/7 17:46
 * @ Version: 1.0
 */
public class MaxLong {
    /*
     * 最长公共子串
     * 1) 动态规划， 二维数组
     * 2） 动态规划，一维数组
     */
    public static int maxLong(String str1, String str2) {
        if (str1 == null || str2 == null || str1.length() == 0 || str2.length() == 0) {
            return 0;
        }
        int m = str1.length();
        int n = str2.length();
        int[][] dp = new int[m + 1][n + 1];
        int max = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (str1.charAt(i -1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i -1][j - 1] + 1;
                } else {
                    dp[i][j] = 0;
                }
                max = Math.max(dp[i][j], max);
            }
        }
        return max;
    }

    public static int maxLong02(String str1, String str2) {
        if (str1 == null || str2 == null || str1.length() == 0 || str2.length() == 0) {
            return 0;
        }
        int m = str1.length();
        int n = str2.length();
        int[] dp = new int[n + 1];
        int maxVal = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = n; j >= 1 ; j--) {
                if (str1.charAt(i - 1) == str2.charAt(j -1)) {
                    dp[j] = dp[j -1] + 1;
                } else {
                    dp[j] = 0;
                }
                maxVal = Math.max(maxVal, dp[j]);
            }
        }
        return maxVal;
    }

    public static void main(String[] args) {
        String str1 = "people";
        String str2 = "eplm";
        int res = maxLong02(str1, str2);
        System.out.println(res);
    }
}
