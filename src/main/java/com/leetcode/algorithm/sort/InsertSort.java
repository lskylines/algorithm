package com.leetcode.algorithm.sort;

import com.leetcode.algorithm.basic.GenerateData;

import java.util.Arrays;

/**
 * @ ClassName InsertSort
 * @ author lskyline
 * @ 2021/3/28 15:24
 * @ Version: 1.0
 */
public class InsertSort {
    /**插入排序*/
    public static void insertSort(int[] arr, int n) {
        if (n <= 1) {
            return;
        }
        for (int i = 1; i < n; i++) {
            int value = arr[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (arr[j] > value) {
                    arr[j+1] = arr[j];
                } else {
                    break ;
                }
            }
            arr[j+1] = value;
        }
    }

    public static void insertSort02(int[] arr, int n) {
        if (n <= 1) {
            return ;
        }
        for (int i = 1; i < n; i++) {
            int value = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > value) {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j + 1] = value;
        }
    }

    public static void main(String[] args) {
        int[] arr = GenerateData.generate(100);
        System.out.println(Arrays.toString(arr));
        insertSort02(arr, arr.length);
        Boolean flag = GenerateData.isOrder(arr);
        System.out.println(flag);
    }
}
