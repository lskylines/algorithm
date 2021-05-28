package com.leetcode.algorithm.array;

import java.util.Arrays;

/**
 * @ ClassName Multiply
 * @ author lskyline
 * @ 2021/5/28 21:36
 * @ Version: 1.0
 */
public class Multiply {
    /*
     * 构建乘积数组
     * 1) 左边乘积 * 右边乘积
     */
    public int[] constructArr(int[] a) {
        if (a == null || a.length == 0) {
            return new int[0];
        }
        int len = a.length;
        int[] arr = new int[len];
        int[] left = new int[len];
        int[] right = new int[len];
        left[0] = 1;
        right[len - 1] = 1;
        for (int i = 1; i < len; i++) {
            left[i] = left[i -1] * a[i -1];
        }
        for (int i = len - 2; i >= 0; i--) {
            right[i] = right[i + 1] * a[i + 1];
        }

        for (int i = 0; i < len; i++) {
            arr[i] = left[i] * right[i];
        }
        return arr;
    }

    public static void main(String[] args) {
        Multiply obj = new Multiply();
        int[] arr = new int[]{1, 2, 3, 4, 5};
        int[] target = obj.constructArr(arr);
        System.out.println(Arrays.toString(target));
    }
}
