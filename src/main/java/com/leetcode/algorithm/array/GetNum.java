package com.leetcode.algorithm.array;

import com.leetcode.algorithm.basic.GenerateData;

import java.util.LinkedList;

/**
 * @ ClassName GetNum
 * @ author lskyline
 * @ 2021/4/15 16:09
 * @ Version: 1.0
 */
public class GetNum {
    /*
     * 最大值 - 最小值 <= num 的子数组
     */
    public int getNum(int[] arr, int num) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        LinkedList<Integer> qmax = new LinkedList<>();
        LinkedList<Integer> qmin = new LinkedList<>();
        int start = 0;
        int end  = 0;
        int res = 0;
        while (start < arr.length) {
            while (end < arr.length) {
                while (!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[end]) {
                    qmax.pollLast();
                }
                qmax.addLast(end);
                while (!qmin.isEmpty() && arr[qmin.peekLast()] >= arr[end]) {
                    qmin.pollLast();
                }
                qmin.addLast(end);
                if (arr[qmax.peekFirst()] - arr[qmin.peekFirst()] > num) {
                    break ;
                }
                end++;
            }
            if (qmin.peekFirst() == start) {
                qmin.pollFirst();
            }
            if (qmax.peekFirst() == start) {
                qmax.pollFirst();
            }
            res += (end - start);
            start++;
        }
        return res;
    }

    public  int getNum02(int[] arr, int num) {
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                if (valid(arr, num, i, j)) {
                    res ++;
                }
            }
        }
        return res;
    }

    public boolean valid(int[] arr, int num, int start, int end) {
        int maxValue = Integer.MIN_VALUE;
        int minValue = Integer.MAX_VALUE;
        for (int i = start; i <= end; i++) {
            maxValue = Math.max(maxValue, arr[i]);
            minValue = Math.min(minValue, arr[i]);
        }
        return maxValue - minValue <= num;
    }

    public static void main(String[] args) {
        long start = 0L;
        long end = 0L;
        int testNum = 40000;
        boolean flag = true;
        for (int i = 0; i < testNum; i++) {
            int[] arr = GenerateData.generateRandom(1000, 100);
            GetNum obj = new GetNum();
            start = System.currentTimeMillis();
            int res = obj.getNum02(arr, 3);
            end = System.currentTimeMillis();
            System.out.println("Num02:" + (end - start));

            start = System.currentTimeMillis();
            int res02 = obj.getNum(arr, 3);
            end = System.currentTimeMillis();
            System.out.println("Num01:" + (end - start));
            if (res != res02) {
                flag = false;
                break;
            }
        }
        System.out.println(flag);
    }
}
