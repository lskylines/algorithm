package com.leetcode.algorithm.doublepoint;

/**
 * @ ClassName JudgeSquareSum
 * @ author lskyline
 * @ 2021/5/9 19:57
 * @ Version: 1.0
 */
public class JudgeSquareSum {
    /**
     * 平方数之和
     * 1) 双指针
     */
    public boolean judgeSquareSum(int c) {
        if (c < 0) {
            return false;
        }
        int i = 0;
        int j = (int)(Math.sqrt(c));
        while (i <= j) {
            int powerSum = i * i + j * j;
            if (powerSum == c) {
                return true;
            } else if (powerSum > c) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }
}
