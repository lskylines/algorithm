package com.leetcode.algorithm.dp;

/**
 * @ ClassName NumDecodings
 * @ author lskyline
 * @ 2021/4/19 0:24
 * @ Version: 1.0
 */
public class NumDecodings {
    /*
     *  把数字翻译成字符串
     * 1) 动态规划
     */
    public int numDecodings(String s) {
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= s.length(); i++) {
            String tempStr = s.substring(i-2, i);
            if (tempStr.compareTo("10") >= 0 && tempStr.compareTo("25") <= 0 ) {
                dp[i] = dp[i-1] + dp[i-2];
            } else {
                dp[i] = dp[i-1];
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        String s = "1225";
        NumDecodings obj = new NumDecodings();
        int res = obj.numDecodings(s);
        System.out.println(res);
    }
}
