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

    /**生成N个有序的数据*/
    public static int[] generateOrder(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }
        return arr;
    }

    /**判断是否有序*/
    public static boolean equal(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i+1]) {
                return false;
            }
        }
        return true;
    }
}
