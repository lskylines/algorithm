package com.leetcode.algorithm.dp;

/**
 * @ ClassName PackageProblem
 * @ author lskyline
 * @ 2021/4/22 10:59
 * @ Version: 1.0
 */
public class PackageProblem {
    /*
     * 假设我们背包可容纳的重量是4kg，有3样东西可供我们选择，一个是高压锅有4kg，价值300元，
     * 一个是风扇有3kg，价值200元，最后一个是一双运动鞋有1kg，价值150元。问要装哪些东西在重
     * 量不能超过背包容量的情况下价值最大   TODO 重新理解
     */
    public static int packageProblem() {
        int packageWeight = 4;
        int[] weight = {1, 4, 3};
        int[] value = {150, 300, 200};
        int[][] dp = new int[weight.length + 1][packageWeight + 1];
        for (int i = 1; i <= value.length; i++) {
            for (int j = 1; j <= packageWeight; j++) {
                if (j >= weight[i-1]) {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-weight[i-1]] + value[i-1]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[weight.length][packageWeight];
    }

    public static int packageProblem02() {
        int packageWeight = 4;
        int[] weight = {1, 4, 3};
        int[] value = {150, 300, 200};
        int[] dp = new int[packageWeight + 1];
        for (int i = 1; i <= value.length; i++) {
            for (int j = packageWeight; j >= 1; j--) {
                if (j - weight[i-1] >= 0) {
                    dp[j] = Math.max(dp[j], dp[j-weight[i - 1]] + value[i-1]);
                }
            }
        }
        return dp[packageWeight];
    }
    public static void main(String[] args) {
        int maxValue = packageProblem();
        System.out.println(maxValue);
    }
}
