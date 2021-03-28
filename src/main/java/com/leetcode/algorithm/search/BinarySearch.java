package com.leetcode.algorithm.search;

import com.leetcode.algorithm.basic.GenerateData;

import java.util.Arrays;

/**
 * @ ClassName BinarySearch
 * @ author lskyline
 * @ 2021/3/28 19:43
 * @ Version: 1.0
 */
public class BinarySearch {
    /**
     * 二分查找
     */
    public static int binarySearch(int[] arr, int n, int target) {
        int low = 0 ;
        int high = n;
        int mid = low + ((high - low) >> 1);
        while (low <= high) {
            if (arr[low] == target) {
                return low ;
            } else if (arr[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
            mid = low + ((high -low) >> 1);
        }
        return -1;
    }

    /**
     * 递归实现二分
     */
    public static int binarySearchRecur(int[] arr, int low, int high, int target) {
        if (low > high) {
            return -1;
        }
        int mid = low + ((high - low) >> 1);
        if (arr[mid] == target) {
            return mid;
        } else if (arr[mid] > target) {
            return binarySearchRecur(arr, low, mid -1, target);
        } else {
            return binarySearchRecur(arr, mid  + 1, high, target);
        }
    }

    public static void main(String[] args) {
        int[] arr = GenerateData.generateOrder(100);
        int index = binarySearchRecur(arr, 0, arr.length - 1, 20);
        System.out.println(index);
    }
}
