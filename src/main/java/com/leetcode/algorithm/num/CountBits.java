package com.leetcode.algorithm.num;

import java.util.Arrays;

/**
 * @ ClassName CountBits
 * @ author lskyline
 * @ 2021/4/28 23:09
 * @ Version: 1.0
 */
public class CountBits {
    /**
     * 比特位计数
     * 1) 直接计算
     * 2) 动态规划
     */
    public int[] countBits(int nums) {
        int[] bits = new int[nums + 1];
        for (int i = 1; i <= nums; i++) {
            bits[i] = getBit(i);
        }
        return bits;
    }

    public int[] countBits02(int nums) {
        int[] bits = new int[nums + 1];
        bits[0] = 0;
        for (int i = 1; i <= nums; i++) {
            if (i % 2 == 0) {
                bits[i] = bits[i / 2];
            } else {
                bits[i] = bits[i-1] + 1;
            }
        }
        return bits;
    }

    private int getBit(int num) {
        int res = 0;
        while (num != 0) {
            num &= (num -1);
            res++;
        }
        return res;
    }

    public static void main(String[] args) {
        CountBits obj = new CountBits();
        int[] res = obj.countBits(5);
        System.out.println(Arrays.toString(res));
    }
}
