package com.leetcode.algorithm.doublepoint;

import java.util.Arrays;

/**
 * @ ClassName Merge
 * @ author lskyline
 * @ 2021/5/9 20:37
 * @ Version: 1.0
 */
public class Merge {
    /*
     * 合并两个有序数组
     * 1)双指针
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        int index = m + n - 1;
        while (p2 >= 0) {
            if (p1 < 0) {
                nums1[index--] = nums2[p2--];
            } else if (p2 < 0) {
                nums1[index--] = nums1[p1--];
            } else if (nums1[p1] > nums2[p2]) {
                nums1[index--] = nums1[p1--];
            } else {
                nums1[index--] = nums2[p2--];
            }
        }
        System.out.println(Arrays.toString(nums1));
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{0};
        int[] nums2 = new int[]{1};
        Merge obj = new Merge();
        obj.merge(nums1, 0, nums2, 1);

    }
}
