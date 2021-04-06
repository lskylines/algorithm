package com.leetcode.algorithm.basic;


import java.util.Random;

/**
 * @ ClassName GenerateData
 * @ author lskyline
 * @ 2021/3/28 11:37
 * @ Version: 1.0
 */
public class GenerateData {
    private static int MAX_VALUE = 100;

    /**生成N个[0-100]随机数据*/
    public static int[] generate(int n) {
        Random random = new Random();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(MAX_VALUE);
        }
        return arr;
    }


    /**生成随机大小的随机数*/
    public static int[] generateRandom(int size, int value) {
        int[] arr = new int[(int)((size + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((value + 1) * Math.random()) - (int) ((value) * Math.random());
        }
        return arr;
    }

    /**生成N个有序的数据*/
    public static int[] generateOrder(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }
        return arr;
    }
    /**判断是否有序*/
    public static boolean isOrder(int[] arr) {
        if (arr == null || arr.length < 2) {
            return true;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }

    /**判断两个数组是否相等*/
    public static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    /**复制数组*/
    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }
}
