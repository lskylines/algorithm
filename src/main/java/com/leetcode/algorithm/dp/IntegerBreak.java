package com.leetcode.algorithm.dp;

import java.util.Arrays;

/**
 * @ ClassName IntegerBreak
 * @ author lskyline
 * @ 2021/5/9 9:27
 * @ Version: 1.0
 */
public class IntegerBreak {
    /**
     * 整数拆分
     * 1) 动态规划
     * 2) 等价于剪绳子
     */
    public int integerBreak(int n) {
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            int curMax = 0;
            for (int j = 1; j < i; j++) {
                curMax = Math.max(curMax, Math.max(j * (i - j), j * dp[i - j]));
            }
            dp[i] = curMax;
        }
        System.out.println(Arrays.toString(dp));
        return dp[n];
    }

    public int integerBreak02(int n) {
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                //剪掉的第一段， 剩下的(i - j)不剪， 乘积为 j * (i - j)
                //剩下的继续剪, 乘积为 j * (dp[i - j])
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 10;
        IntegerBreak obj = new IntegerBreak();
        obj.integerBreak(n);

    }
}
