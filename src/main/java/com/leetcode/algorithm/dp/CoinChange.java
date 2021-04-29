package com.leetcode.algorithm.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ ClassName CoinChange
 * @ author lskyline
 * @ 2021/4/27 19:53
 * @ Version: 1.0
 */
public class CoinChange {
    /*
     * 零钱兑换
     * 1) 递归
     * 2）动态规划
     */
    public int coinChange(int[] coins, int amount) {
        if (coins.length == 0) {
            return 0;
        }
        int[] money = new int[amount];
        int res = findWay(coins, amount, 0,  money);
        return res;
    }

    public int coinChange02(int[] coints, int amount) {
        if (coints == null || coints.length == 0) {
            return -1;
        }
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        System.out.println(Arrays.toString(dp));
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coints.length; j++) {
                if (i - coints[j] >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - coints[j]] + 1);
                }
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[amount] > amount  ? -1 : dp[amount];

    }


    private int findWay(int[] coins, int amount, int count, int[] mony) {
        if (amount < 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }
        if (mony[amount - 1] != 0) {
            return mony[amount - 1];
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            if (coins[i] > amount) {
                continue;
            }
            int res = findWay(coins, amount - coins[i], count + 1, mony);
            if (res >= 0 && res < min) {
                min = res + 1;
            }
        }
        mony[amount -1] = (min == Integer.MAX_VALUE ? -1 : min);
        return mony[amount - 1];
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 5};
        CoinChange obj = new CoinChange();
        int res = obj.coinChange02(arr, 11);
        System.out.println(res);
    }
}
