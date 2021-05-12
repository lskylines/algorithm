package com.leetcode.algorithm.dp;

/**
 * @ ClassName IsSubsequence
 * @ author lskyline
 * @ 2021/5/10 0:56
 * @ Version: 1.0
 */
public class IsSubsequence {
    /*
     *  判断子序列
     */
    public boolean isSubsequence(String s, String t) {

        int m = s.length();
        int n = t.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (t.charAt(i - 1) == s.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[n][m] == m;
    }
}