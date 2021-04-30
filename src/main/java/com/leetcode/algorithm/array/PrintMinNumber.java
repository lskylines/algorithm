package com.leetcode.algorithm.array;

import java.util.Arrays;

/**
 * @ ClassName PrintMinNumber
 * @ author lskyline
 * @ 2021/4/18 23:36
 * @ Version: 1.0
 */
public class PrintMinNumber {
    /*
     * 把数组排成最小的数
     */
    public String printMinNumber(int[] num) {
        if (num == null || num.length == 0) {
            return "";
        }
        int n = num.length;
        String[] nums = new String[n];
        for (int i = 0; i < n; i++) {
            nums[i] = String.valueOf(num[i]);
        }
        Arrays.sort(nums, (o1, o2) -> (o1 + o2).compareTo(o2 + o1));
        System.out.println(Arrays.toString(nums));
        return "";
    }
    public static void main(String[] args) {
        int[] arr = new int[]{3, 32, 321};
        PrintMinNumber obj = new PrintMinNumber();
        String s = obj.printMinNumber(arr);

    }
}
