package com.leetcode.algorithm.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * @ ClassName CutRope
 * @ author lskyline
 * @ 2021/4/19 17:25
 * @ Version: 1.0
 */
public class CutRope {
    /*
     * 剪绳子
     * 1) 递归 + 记忆化
     * 2） 动态规划
     */
    private Map<Integer, Integer> map = new HashMap<>();
    public int cutRope(int n) {
        if (n == 2) {
            return 1;
        }
        if (map.containsKey(n)) {
            return map.get(n);
        }
        int res = 0;
        for (int i = 1; i < n; i++) {
            res = Math.max(res, Math.max(cutRope(n - i) * i, i * (n-i)));
            map.put(n, res);
        }
        return res;
    }

    public int cutRope02(int n) {
        int[] dp = new int[n + 1];
        //绳子剪掉一段后，如果剪掉长度为1，对最后的乘积没有增益，所以从长度为2开始
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            for (int j = 2; j < i; j++) {
                //剪掉的绳子第一段， 剩下的(i - j)不剪， 乘积为 j * (i - j)
                //剩下的继续剪, 乘积为 j * (dp[i - j])
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        CutRope obj = new CutRope();
        int res = obj.cutRope(8);
        System.out.println(res);
    }
}
