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
     * 剪绳子 //todo DP待优化
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

    public static void main(String[] args) {
        CutRope obj = new CutRope();
        int res = obj.cutRope(8);
        System.out.println(res);
    }
}
