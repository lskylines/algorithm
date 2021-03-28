package com.leetcode.algorithm.search;

/**
 * @ ClassName BinarySearchVariant
 * @ author lskyline
 * @ 2021/3/28 21:56
 * @ Version: 1.0
 */
public class BinarySearchVariant {
    /*
     * 二分查找变体
     * 1) 查找第一个值等于给定值的元素
     * 2) 查找最后一个值等于给定值的元素
     * 3）查找第一个大于给定值的元素
     * 4）查找最后一个小于等于给定值的元素
     */

    public static int bfSearch(int[] arr, int n, int value) {
        int low = 0;
        int high = n -1;
        int mid = low + ((high - low ) >> 1);
        while (low <= high) {
            if (arr[mid] < value) {
                low = mid + 1;
            } else if (arr[mid] > value) {
                high = mid - 1;
            } else {
                if ((mid == 0) || (arr[mid -1] != value)) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            }
            mid = low + ((high - low)>>1);
        }
        return -1;
    }

    public static int blSearch(int[] arr, int n, int value) {
        int low = 0;
        int high = n -1;
        int mid = low + ((high - low)>>1);
        while (low <= high) {
            if (arr[mid] > value) {
                high = mid -1;
            } else if (arr[mid] < value) {
                low = mid + 1;
            } else {
                if ((mid == n-1) || (arr[mid + 1] != value)) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            }
            mid = low + ((high - low)>>1);
        }
        return -1;
    }

    public static int bfgSearch(int[] arr, int n, int value) {
        int low = 0;
        int high = n -1;
        while (low <= high) {
            int mid = low + ((high - low)>>1);
            if (arr[mid] >= value) {
                if ((mid == 0) || (arr[mid-1] < value)) {
                    return mid;
                }
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public static int blgSearch(int[] arr, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low )>>1);
            if (arr[mid] > value) {
                high = mid - 1;
            } else {
                if ((mid == n -1) ||(arr[mid + 1] > value)) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 4, 5, 6, 8, 8, 8, 11, 18};
        int index = bfgSearch(arr,  arr.length, 2);
        System.out.println(index);
    }
}
