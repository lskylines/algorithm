package com.leetcode.algorithm.Strings;

/**
 * @ ClassName IsPalindromic
 * @ author lskyline
 * @ 2021/4/24 9:53
 * @ Version: 1.0
 */
public class IsPalindromic {
    /*
     * 最长回文子串 (Wonderful)
     * 1) 暴力解法
     * 2) 动态规划 //todo 存在问题，待优化
     */
    public String longestPalindrome(String str) {
        String ans = "";
        int max = 0;
        int len = str.length();
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j <= len; j++) {
                String test = str.substring(i, j);
                if (isPalindromic(test) && test.length() > max) {
                    ans = test;
                    max = Math.max(max, ans.length());
                }
            }
        }
        return ans;
    }

    public String longestPalindrome02(String str) {
        String ans = "";
        int max = 0;
        String revStr = new StringBuilder(str).reverse().toString();
        int[][] dp = new int[str.length()][revStr.length()];
        int maxValue = 0;
        int maxEnd  = 0;
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (str.charAt(i) == revStr.charAt(j)) {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = dp[i-1][j-1] + 1;
                    }
                }
                if (dp[i][j] > maxValue) {
                    maxValue = dp[i][j];
                    maxEnd = i;
                }
            }
        }
        return str.substring(maxEnd - maxValue + 1, maxEnd + 1);
    }

    private boolean isPalindromic(String s) {
        int len = s.length();
        for (int i = 0; i < len / 2; i++) {
            if (s.charAt(i) != s.charAt(len - i - 1)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        IsPalindromic obj = new IsPalindromic();
        String s = "aacabdkacaa";
        String ans = obj.longestPalindrome02(s);
        System.out.println(ans);
    }
}
