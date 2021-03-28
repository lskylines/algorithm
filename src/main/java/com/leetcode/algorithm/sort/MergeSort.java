package com.leetcode.algorithm.sort;

import com.leetcode.algorithm.basic.GenerateData;

/**
 * @ ClassName MergeSort
 * @ author lskyline
 * @ 2021/3/28 16:08
 * @ Version: 1.0
 */
public class MergeSort {
    /**归并排序*/
    public static void mergeSort(int[] arr, int left, int right) {
        if (arr.length <= 1) {
            return ;
        }
        int mid = left + ((right - left) >> 1);
        if (left < right) {
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }
    public static void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= right) {
            if (arr[i] > arr[j]) {
                temp[k++] = arr[j++];
            } else {
                temp[k++] = arr[i++];
            }
        }
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        while (j <= right) {
            temp[k++] = arr[j++];
        }

        for (int u = 0; u < temp.length; u++) {
            arr[u + left] = temp[u];
        }
    }

    public static void main(String[] args) {
        int[] arr = GenerateData.generate(100);
        mergeSort(arr, 0, arr.length - 1);
        boolean flag = GenerateData.equal(arr);
        System.out.println(flag);
    }
}
