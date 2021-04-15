package com.leetcode.algorithm.array;

import com.leetcode.algorithm.basic.GenerateData;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @ ClassName GetMinWindow
 * @ author lskyline
 * @ 2021/4/15 15:17
 * @ Version: 1.0
 */
public class GetMinWindow {
    /*
     * 窗口最小值
     */
    public static int[] getMinWindow(int[] arr, int w) {
        if (arr == null || arr.length < w) {
            return null;
        }
        int[] res = new int[arr.length - w + 1];
        int index = 0;
        LinkedList<Integer> qmin = new LinkedList<>();
        for (int i = 0; i < arr.length; i++) {
            while (!qmin.isEmpty() && arr[qmin.peekLast()] >= arr[i]) {
                qmin.pollLast();
            }
            qmin.addLast(i);
            if (qmin.peekFirst() == i - w) {
                qmin.pollFirst();
            }
            if (i >= w - 1) {
                res[index++] = arr[qmin.peekFirst()];
            }
        }
        return res;
    }

    public static int[] getMinWindow02(int[] arr, int w) {
        if (arr == null || arr.length < w) {
            return null;
        }
        int[] res = new int[arr.length - w + 1];
        int index = 0;
        int left = 0;
        int right = w;
        int minValue = Integer.MAX_VALUE;
        while (right <= arr.length) {
            minValue = findMinValue(arr, left, right);
            res[index++] = minValue;
            left++;
            right++;
        }
        return res;
    }

    public static int findMinValue(int[] arr, int left, int right) {
        int minValue = arr[left];
        for (int i = left+1; i < right; i++) {
            minValue = Math.min(minValue, arr[i]);
        }
        return minValue;
    }

    public static void main(String[] args) {
        int testNum = 50000;
        boolean flag = true;
        for (int i = 0; i < testNum; i++) {
            int[] arr = GenerateData.generateRandom(100, 100);
            int[] copyArr = GenerateData.copyArray(arr);
            int[] res = getMinWindow(arr, 4);
            int[] help = getMinWindow02(copyArr, 4);
            if (!GenerateData.isEqual(res, help)) {
                flag = false;
                break ;
            }
        }
        System.out.println(flag);
    }
}
