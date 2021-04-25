package com.leetcode.algorithm.array;

import java.util.Arrays;

/**
 * @ ClassName SortColors
 * @ author lskyline
 * @ 2021/4/25 22:56
 * @ Version: 1.0
 */
public class SortColors {
    /*
     * 颜色分类
     *
     */
    public void sortColors(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return ;
        }
        int n = nums.length;
        int p0 = 0, p1 = 0;
        for (int i = 0; i < n; ++i) {
            if (nums[i] == 1) {
                swap(nums, i, p1);
                ++p1;
            } else if (nums[i] == 0) {
                swap(nums, i, p0);
                if (p0 < p1) {
                    swap(nums,i ,p1);
                }
                ++p0;
                ++p1;
            }
        System.out.println(Arrays.toString(nums));
        }
    }

    public void sortColors02(int[] arr) {
        int n = arr.length;
        int p0 = 0, p2 = n - 1;
        for (int i = 0; i <= p2; ++i) {
            while (i <= p2 && arr[i] == 2) {
                swap(arr, i, p2);
                --p2;
            }
            if (arr[i] == 0) {
                swap(arr, i, p0);
                ++p0;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 0, 2, 1, 1, 0};
        SortColors obj = new SortColors();
        obj.sortColors02(arr);
    }

}
