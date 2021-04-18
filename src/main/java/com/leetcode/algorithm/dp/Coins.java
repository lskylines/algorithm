package com.leetcode.algorithm.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * @ ClassName Coins
 * @ author lskyline
 * @ 2021/4/18 14:57
 * @ Version: 1.0
 */
public class Coins {

    /*
     * 零钱兑换
     */
    private static Map<String, Integer> map = new HashMap<>();
    public static int contains(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return 0;
        }
        return process(arr, 0, aim);
    }


    public static int contains02(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return 0;
        }
        return dp(arr, aim);
    }


    public static int dp(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return 0;
        }
        int[][] dp = new int[arr.length + 1][aim + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 1;
        }
        for (int i = dp.length - 2; i >= 0; i--) {
            for (int j = 1; j <= aim; j++) {
                dp[i][j] = dp[i+1][j];
                dp[i][j] += j - arr[i] >=0 ? dp[i][j-arr[i]] : 0;
            }
        }
        return dp[0][aim];
    }

    public static void print(int[][] dp) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static int process(int[] arr, int index, int aim) {
        int res = 0;
        if (index == arr.length) {
            res =  aim == 0 ? 1 : 0;
        } else {
            for (int i = 0; arr[index] * i <= aim; i++) {
                res += process(arr, index + 1, aim - arr[index] * i);
            }
        }
        return res;
    }

    public static int process_map(int[] arr, int index, int aim) {
        int res = 0;
        if (index == arr.length) {
            res = aim == 0 ? 1 : 0;
        } else {
            for (int i = 0; arr[index] * i <= aim; i++) {
                int nextAim = aim - arr[index] * i;
                String key = String.valueOf(index + 1) + "_" + String.valueOf(nextAim);
                if (map.containsKey(key)) {
                    res += map.get(key);
                } else {
                    res += process_map(arr, index + 1, nextAim);
                }
            }
        }
        map.put(String.valueOf(index) + "_" + String.valueOf(aim), res);
        return res;
    }


    public static void main(String[] args) {
        int[] arr = new int[]{200, 100, 50, 20, 5, 1};
        long start = System.nanoTime();
        int res = contains(arr, 1000);
        long end = System.nanoTime();
        System.out.println("spend time:" + ((end - start) / 1_000_000));
        System.out.println(res);
        start = System.nanoTime();
        System.out.println("dbp2:" + contains02(arr, 1000));
        end = System.nanoTime();
        System.out.println("Spend Time:" + ((end - start) / 1_000_000));
    }
}
