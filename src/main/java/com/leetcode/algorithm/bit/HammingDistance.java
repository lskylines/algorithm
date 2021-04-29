package com.leetcode.algorithm.bit;

/**
 * @ ClassName HammingDistance
 * @ author lskyline
 * @ 2021/4/29 16:39
 * @ Version: 1.0
 */
public class HammingDistance {
    /*
     * 汉明距离
     * 1) 异或处理后进行统计1的个数
     */
    public int hammingDistance(int x, int y) {
        int res = x ^ y;
        int cnt = 0;
        while (res != 0) {
            res &= (res -1);
            cnt++;
        }
        return cnt;
    }
}
