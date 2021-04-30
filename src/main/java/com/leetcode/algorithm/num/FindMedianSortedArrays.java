package com.leetcode.algorithm.num;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @ ClassName MiddleNum
 * @ author lskyline
 * @ 2021/4/30 9:44
 * @ Version: 1.0
 */
public class FindMedianSortedArrays {
    /*
     *  寻找两个正序数组的中位数
     * 1) 归并成大数组
     * 2）
     */
    private int N = 0;
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length == 0 && nums2.length == 0) {
            return 0.0;
        }
        int[] help = merge(nums1, nums2);
        System.out.println(Arrays.toString(help));
        if ((help.length & 1) == 1) {
            return (double)help[help.length / 2];
        } else {
            return ((double) help[help.length / 2 - 1] + (double) help[help.length / 2]) / 2;
        }
    }



    private int[] merge(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int[] help = new int[len1 + len2];
        int p1 = 0;
        int p2 = 0;
        int index = 0;
        while (p1 < len1 && p2 < len2) {
            help[index++] = nums1[p1] < nums2[p2] ? nums1[p1++] : nums2[p2++];
        }
        while (p1 < len1) {
            help[index++] = nums1[p1++];
        }
        while (p2 < len2) {
            help[index++] = nums2[p2++];
        }
        return help;
    }

    public static void main(String[] args) {
        FindMedianSortedArrays obj = new FindMedianSortedArrays();
        int[] num1 = new int[]{1, 3};
        int[] num2 = new int[]{2, 4};
        double res = obj.findMedianSortedArrays(num1, num2);
        System.out.println(res);
    }
}
