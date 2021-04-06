package com.leetcode.algorithm.sort;

import com.leetcode.algorithm.basic.GenerateData;
import com.leetcode.algorithm.basic.GenerateSort;

/**
 * @ ClassName QuickSort
 * @ author lskyline
 * @ 2021/4/6 15:03
 * @ Version: 1.0
 */
public class QuickSort {
    /**
     * 经典快速排序
     */
    public static void quickSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return ;
        }
        quickSort(arr, 0, arr.length - 1);
    }

    public static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int p = partition(arr, left, right);
            quickSort(arr, left, p -1);
            quickSort(arr, p + 1, right);
        }
    }

    public static int partition(int[] arr, int L, int R) {
        int less = L - 1;
        int more = R;
        int current = L;
        while (current < more) {
            if (arr[current] < arr[R]) {
                swap(arr, ++less, current++);
            } else if (arr[current] > arr[R]) {
                swap(arr, --more, current);
            } else {
                current ++;
            }
        }
        swap(arr, more, R);
        return more;
    }



    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int testNum = 50000;
        int size = 10;
        int value = 100;
        boolean flag = true;
        for (int i = 0; i < testNum; i++) {
            int[] arr = GenerateData.generateRandom(size, value);
            int[] temp = GenerateData.copyArray(arr);
            GenerateSort.sort(arr);
            quickSort(temp);
            if (!GenerateData.isEqual(arr, temp)) {
                flag = false;
                break ;
            }
        }
        System.out.println(flag);
    }
}

