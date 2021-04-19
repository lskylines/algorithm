package com.leetcode.algorithm.num;

/**
 * @ ClassName UglyNumber
 * @ author lskyline
 * @ 2021/4/19 9:47
 * @ Version: 1.0
 */
public class UglyNumber {
    /*
     * 丑数
     */
    public int uglyNumber(int n) {
        int[] dp = new int[n+1];
        dp[1] = 1;
        int p2 = 1;
        int p3 = 1;
        int p5 = 1;
        for (int i = 2; i <= n; i++) {
            int num2 = dp[p2] * 2;
            int num3 = dp[p3] * 3;
            int num5 = dp[p5] * 5;
            dp[i] = Math.min(Math.min(num2, num3), num5);
            if (dp[i] == num2) {
                p2++;
            }
            if (dp[i] == num3) {
                p3++;
            }
            if (dp[i] == num5) {
                p5++;
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        UglyNumber obj = new UglyNumber();
        int res = obj.uglyNumber(10);
        System.out.println(res);
    }
}
