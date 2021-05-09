package com.leetcode.algorithm.greedy;

/**
 * @ ClassName CanPlaceFlowers
 * @ author lskyline
 * @ 2021/5/10 0:44
 * @ Version: 1.0
 */
public class CanPlaceFlowers {
    /*
     * 种花问题
     * 1) 贪心策略
     */
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (flowerbed == null || flowerbed.length == 0) {
            return false;
        }
        int preNum = 0;
        int afterNum = 0;
        int cnt = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 1) {
                continue;
            }
            preNum = i == 0 ? flowerbed[0] : flowerbed[i - 1];
            afterNum = i == flowerbed.length - 1 ? flowerbed[flowerbed.length -1] : flowerbed[i + 1];
            //前一个以及后一个都没有种花，直接种下，且记录+1
            if (preNum == 0 && afterNum == 0) {
                cnt++;
                flowerbed[i] = 1;
            }
        }
        return cnt >= n;
    }
}
