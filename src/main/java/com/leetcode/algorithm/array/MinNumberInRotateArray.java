package com.leetcode.algorithm.array;

/**
 * @ ClassName MinNumberInRotateArray
 * @ author lskyline
 * @ 2021/4/9 9:41
 * @ Version: 1.0
 */
public class MinNumberInRotateArray {
    /**
     * 旋转数组的最小数字
     * 1) 使用二分
     */
    public int minNumberInRotateArray(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int low = 0;
        int high = arr.length - 1;
        int mid = low;
        while (arr[low] >= arr[high]) {
            mid = low + ((high - low) >> 1);
            if (high - low == 1) {
                mid = high;
                break ;
            }
            if (arr[low] == arr[mid] && arr[low] == arr[high]) {
                return findMinNum(arr);
            }
            if (arr[mid] >= arr[low]) {
                low = mid;
            } else if (arr[mid] <= arr[high]) {
                high = mid;
            }
        }
        return arr[mid];
    }

    public int findMinNum(int[] arr) {
        int minValue = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            minValue = Math.max(minValue, arr[i]);
        }
        return minValue;
    }

    public static void main(String[] args) {
        MinNumberInRotateArray obj = new MinNumberInRotateArray();
        int[] arr = new int[]{0, 1, 1, 1, 1};
        int res = obj.minNumberInRotateArray(arr);
        System.out.println(res);
    }

}
