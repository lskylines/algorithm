package com.leetcode.algorithm.dp;

/**
 * @ ClassName LongestCommonSubsequence
 * @ author lskyline
 * @ 2021/4/19 22:28
 * @ Version: 1.0
 */
public class LongestCommonSubsequence {
    /*
     * 最长公共子序列 TODO 待优化
     */
    public int longestCommonSubsequence(String text1, String text2) {
        if (text1 == null || text2 == null || text1.length() == 0 || text2.length() == 0) {
            return 0;
        }
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m + 1][n + 1];

        int max = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i -1) == text2.charAt(j -1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = 0;
                }
                max = Math.max(dp[i][j], max);
            }
        }

        printMatrix(dp);
        return max;
    }

    public void printMatrix(int[][] dp) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        LongestCommonSubsequence obj = new LongestCommonSubsequence();
        int res = obj.longestCommonSubsequence("people", "eplm");
        System.out.println(res);
    }
}
