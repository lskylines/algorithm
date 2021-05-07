package com.leetcode.algorithm.array;

/**
 * @ ClassName AllLessNumSubArray
 * @ author lskyline
 * @ 2021/4/11 14:36
 * @ Version: 1.0
 */
public class AllLessNumSubArray {
    /**
     * 子序列最大最小值 < num
     */
    public static int getNum1(int[] arr, int num) {
        int res = 0;
        for (int start = 0; start < arr.length; start++) {
            for (int end = start; end < arr.length; end++) {
                if (isValid(arr, start, end, num)) {
                    res++;
                }
            }
        }
        return res;
    }

    public static boolean isValid(int[] arr, int start, int end, int num) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = start; i <= end; i++) {
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
        }
        return max - min > num;
    }

    public static void main(String[] args) {

    }
}
