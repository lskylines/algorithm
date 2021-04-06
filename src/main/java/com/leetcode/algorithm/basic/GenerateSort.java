package com.leetcode.algorithm.basic;

import java.util.Arrays;

/**
 * @ ClassName GenerateSort
 * @ author lskyline
 * @ 2021/4/6 15:20
 * @ Version: 1.0
 */
public class GenerateSort {
    /**
     * 排序
     */
    public static void sort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return ;
        }
        Arrays.sort(arr);
    }
}
