package com.leetcode.algorithm.array;

import com.leetcode.algorithm.basic.GenerateData;

import java.util.LinkedList;

/**
 * @ ClassName GetMaxWindow
 * @ author lskyline
 * @ 2021/4/11 13:57
 * @ Version: 1.0
 */
public class GetMaxWindow {
    /*
     * 生成窗口最大值数组
     */

    public static int[] getMaxWindow(int[] arr, int w) {
        if (arr == null || arr.length < w || w < 1) {
            return null;
        }
        LinkedList<Integer> qmax = new LinkedList<>();
        int[] res = new int[arr.length - w + 1];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            while (!qmax.isEmpty() && arr[i] >= arr[qmax.peekLast()]) {
                qmax.pollLast();
            }
            qmax.addLast(i);
            if (qmax.peekFirst() == i - w) {
                qmax.pollFirst();
            }
            if (i >= w - 1) {
                res[index++] = arr[qmax.peekFirst()];
            }
        }
        return res;
    }

    public static int[] getMaxWindow02(int[] arr, int w) {
        if (arr == null || arr.length < w || w < 1) {
            return null;
        }
        int left = 0;
        int right = w;
        int[] res = new int[arr.length - w + 1];
        int index = 0;
        while (right <= arr.length) {
            res[index++] = findMax(arr, left, right);
            left++;
            right++;
        }
        return res;
    }

    public static int findMax(int[] arr, int left, int right) {
        int maxValue = Integer.MIN_VALUE;
        for (int i = left; i < right; i++) {
            maxValue = Math.max(arr[i], maxValue);
        }
        return maxValue;
    }

    public static void main(String[] args) {

        int testCount = 4000;
        Boolean flag = true;
        for (int i = 0; i < testCount; i++) {
            int[] arr = GenerateData.generateRandom(10, 10);
            int[] copyArr = GenerateData.copyArray(arr);
            int[] res01 = getMaxWindow(arr, 3);
            int[] res02 = getMaxWindow02(copyArr, 3);
            if (!GenerateData.isEqual(res01, res02)) {
                flag = false;
                break;
            }
        }
        System.out.println(flag);
    }
}
