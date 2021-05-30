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


    public String printMinNumber02(int[] num) {
        String[] strs = new String[num.length];
        for (int i = 0; i < num.length; i++) {
            strs[i] = String.valueOf(num[i]);
        }
        quickSort(strs, 0, strs.length -1);
        StringBuilder sb  = new StringBuilder();
        for (String s : strs) {
            sb.append(s).append("-> ");
        }
        return sb.toString();
    }

    private void quickSort(String[] str, int low, int high) {
        if (low >= high) {
            return ;
        }
        int i = low;
        int j = high;
        String tmp = str[i];
        while (i < j) {
            while ((str[j] + str[low]).compareTo(str[low] + str[j]) >= 0 && i < j) {
                j--;
            }
            while ((str[i] + str[low]).compareTo(str[low] + str[i]) <= 0 && i < j) {
                i++;
            }
            tmp = str[i];
            str[i] = str[j];
            str[j] = tmp;
        }
        str[i] = str[low];
        str[low] = tmp;
        quickSort(str, low, i -1);
        quickSort(str, i + 1, high);
    }


    public static void main(String[] args) {
        int[] arr = new int[]{3, 32, 321};
        PrintMinNumber obj = new PrintMinNumber();
        String s = obj.printMinNumber02(arr);
        System.out.println(s);
    }
}
