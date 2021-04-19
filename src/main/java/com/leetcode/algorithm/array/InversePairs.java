package com.leetcode.algorithm.array;

import com.leetcode.algorithm.basic.GenerateData;

import java.util.Arrays;

/**
 * @ ClassName InversePairs
 * @ author lskyline
 * @ 2021/4/19 10:26
 * @ Version: 1.0
 */
public class InversePairs {
    /*
     * 数组中的逆序对
     */
    public int inversePair(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int cnt = 0;
        int len = nums.length;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (nums[i] > nums[j]) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    private int res;
    public int inversePair02(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        MergeSort(nums, 0, nums.length -1);
        return res;
    }

    public void MergeSort(int[] arr, int left, int right) {
        if (left == right) {
            return ;
        }
        int mid = left + ((right - left) >> 1);
        MergeSort(arr, left, mid);
        MergeSort(arr, mid + 1, right);
        Merge(arr, left, mid, right);
    }

    public void Merge(int[] arr, int left, int mid, int right) {
        int[] help = new int[right-left+1];
        int p1 = left;
        int p2 = mid + 1;
        int index = 0;
        while (p1 <= mid && p2 <= right) {
            if (arr[p1] > arr[p2]) {
                res += (right - p2 + 1);
                help[index++] = arr[p1++];
            } else {
                help[index++] = arr[p2++];
            }
        }

        while (p1 <= mid) {
            help[index++] = arr[p1++];
        }
        while (p2 <= right) {
            help[index++] = arr[p2++];
        }
        for (int i = 0; i < help.length; i++) {
            arr[left + i] = help[i];
        }
    }

    public static void main(String[] args) {
        InversePairs obj = new InversePairs();
        int[] arr = new int[]{7, 4, 6, 4};
        System.out.println(obj.inversePair02(arr));

    }
}
