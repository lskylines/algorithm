package com.leetcode.algorithm.sort;

import java.util.Arrays;

/**
 * @ ClassName SelectSort
 * @ author lskyline
 * @ 2021/3/28 15:57
 * @ Version: 1.0
 */
public class SelectSort {
    /**选择排序*/
    public static void selectSort(int[] arr, int n) {
        if (n <= 1) {
            return ;
        }
        for (int i = 0; i < n; i++) {
            int minValue = arr[i];
            boolean flag = false;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < minValue) {
                    minValue = arr[j];
                }
            }
            arr[i] = minValue;
        }
    }

    public static void main(String[] args) {
        int[] arr = GenerateData.generate(100);
        System.out.println(Arrays.toString(arr));
        selectSort(arr, arr.length);
        boolean flag = GenerateData.equal(arr);
        System.out.println(flag);
    }
}
