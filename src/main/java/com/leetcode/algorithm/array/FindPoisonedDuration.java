package com.leetcode.algorithm.array;

/**
 * @ ClassName FindPoisonedDuration
 * @ author lskyline
 * @ 2021/5/27 23:23
 * @ Version: 1.0
 */
public class FindPoisonedDuration {
    /*
     * 提莫攻击
     */
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if (timeSeries == null || timeSeries.length == 0) {
            return 0;
        }
        int res  = duration;
        for (int i = 1; i < timeSeries.length; i++) {
            res += Math.min(timeSeries[i] - timeSeries[i - 1], duration);
        }
        return res;
    }
}
