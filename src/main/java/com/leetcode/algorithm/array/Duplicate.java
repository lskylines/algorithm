package com.leetcode.algorithm.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @ ClassName Duplicate
 * @ author lskyline
 * @ 2021/4/9 5:40
 * @ Version: 1.0
 */
public class Duplicate {
    /**
     * 寻找数据范围[0-n]中，存在重复的数字
     * 1) 排序后，找出重复元素
     * 2) 使用哈希表查找出重复的元素
     * 3） 重排数组
     */
    public static int duplicate(int[] arr) {
        if (arr == null || arr.length < 2) {
            return -1;
        }

        quickSort(arr);
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                return arr[i];
            }
        }
        return -1;
    }

    public static int duplicate02(int[] arr) {
        if (arr == null || arr.length < 2) {
            return -1;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (!map.containsKey(arr[i])) {
                map.put(arr[i], 1);
            } else {
                return arr[i];
            }
        }
        return -1;
    }

    public static int duplicate03(int[] arr) {
        if (arr == null || arr.length < 2) {
            return -1;
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0 || arr[i] > arr.length -1) {
                return -1;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            while (arr[i] != i) {
                if (arr[i] == arr[arr[i]]) {
                    return arr[i];
                } else {
                    swap(arr, i, arr[i]);
                }
            }
        }
        return -1;
    }

    public static void quickSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return ;
        }
        quickSort(arr, 0, arr.length - 1);
    }

    public static void quickSort(int[] arr, int left, int right) {
        if (left <= right) {
            swap(arr, right, left + (int)(Math.random() * ((right - left + 1))));
            int[] p = partition(arr, left, right);
            quickSort(arr, left, p[0] -1);
            quickSort(arr, p[0] + 1, right);
        }
    }

    public static int[] partition(int[] arr, int left, int right) {
        int less = left - 1;
        int more = right;
        int current = left;
        while (current < more) {
            if (arr[current] > arr[right]) {
                swap(arr, current, --more);
            } else if (arr[current] < arr[right]) {
                swap(arr, current++, ++less);
            } else {
                current++;
            }
        }
        swap(arr,more, right);
        return new int[]{less +1, more};
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 1, 0, 2, 5, 3};
        int target = duplicate03(arr);
        System.out.println(target);
    }
}
