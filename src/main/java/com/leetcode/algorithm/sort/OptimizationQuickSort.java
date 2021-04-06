package com.leetcode.algorithm.sort;

import com.leetcode.algorithm.basic.GenSwap;
import com.leetcode.algorithm.basic.GenerateData;
import com.leetcode.algorithm.basic.GenerateSort;

/**
 * @ ClassName OptimizationQuickSort
 * @ author lskyline
 * @ 2021/4/6 15:59
 * @ Version: 1.0
 */
public class OptimizationQuickSort {
    /**
     * 经典快排优化
     */
    public static void quickSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return ;
        }
        quickSort(arr, 0, arr.length - 1);
    }
    public static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            //将Partition过程分为 (left, num) [num...]  (num, right)
            int[] p = partition(arr, left, right);
            quickSort(arr, left, p[0] - 1);
            quickSort(arr, p[1] + 1, right);
        }
    }

    public static int[] partition(int[] arr, int left, int right) {
        int less = left - 1;
        int more = right;
        int current = left;
        while (current < more) {
            if (arr[current] < arr[right]) {
                swap(arr, current++, ++less);
            } else if (arr[current] > arr[right]) {
                swap(arr, current, --more);
            } else {
                current++;
            }
        }
        swap(arr, more, right);
        return new int[] {less + 1, more};
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i]  = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int testNum = 50000;
        int maxSize = 100;
        int maxValue = 100;
        boolean flag = true;
        for (int i = 0; i < testNum; i++) {
            int[] arr = GenerateData.generateRandom(maxSize, maxValue);
            int[] copyArr = GenerateData.copyArray(arr);
            GenerateSort.sort(arr);
            quickSort(copyArr);
            if (!GenerateData.isEqual(arr, copyArr)) {
                flag = false;
                break ;
            }
        }
        System.out.println(flag);
    }
}
