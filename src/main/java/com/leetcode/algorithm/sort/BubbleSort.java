package com.leetcode.algorithm.sort;

import com.leetcode.algorithm.basic.GenerateData;

import java.util.Arrays;

/**
 * @ ClassName BubbleSort
 * @ author lskyline
 * @ 2021/3/28 11:33
 * @ Version: 1.0
 */
public class BubbleSort {
    //冒泡排序
    public static void bubbleSort(int[] arr, int n) {
        if (n <= 1) {
            return;
        }
        for (int i = 0; i < n; i++) {
            boolean flag = false;
            for (int j = 0; j < n-i-1; j++) {
                if (arr[j] > arr[j+1]) {
                    swap(arr, j, j+1);
                    flag = true;
                }
            }
            if (!flag) {
                break ;
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = GenerateData.generate(100);
        System.out.println(Arrays.toString(arr));
        bubbleSort(arr, arr.length);
        boolean flag = GenerateData.isOrder(arr);
        System.out.println(flag);
    }
}
