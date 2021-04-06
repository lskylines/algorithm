package com.leetcode.algorithm.sort;

/**
 * @ ClassName NetherlandsFlag
 * @ author lskyline
 * @ 2021/4/6 14:44
 * @ Version: 1.0
 */
public class NetherlandsFlag {
    /**
     * 荷兰国旗问题
     */
    public static int[] partition(int[] arr,int L, int R, int num) {
        int less = L - 1;
        int more = R + 1;
        int current = L;
        while (current < more) {
            if (arr[current] < num) {
                swap(arr, current++, ++less);
            } else if (arr[current] > num) {
                swap(arr, current, --more);
            } else {
                current++;
            }
        }
        return new int[]{less + 1, more - 1};
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
