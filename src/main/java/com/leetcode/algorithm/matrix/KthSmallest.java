package com.leetcode.algorithm.matrix;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @ ClassName KthSmallest
 * @ author lskyline
 * @ 2021/5/9 19:07
 * @ Version: 1.0
 */
public class KthSmallest {
    /*
     * 有序矩阵中第 K 小的元素
     * 1) 最大堆
     * 2) 基于Partition
     */
    public int kthSmallest(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        Queue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                maxHeap.add(matrix[i][j]);
                if (maxHeap.size() > k) {
                    maxHeap.poll();
                }
            }
        }
        return maxHeap.poll();
    }

    public int kthSmallest02(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int[] res = new int[row * col];
        int index = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                res[index++] = matrix[i][j];
            }
        }
        findSmallest(res, k - 1);
        return res[k - 1];
    }

    private void findSmallest(int[] res, int k) {
        int low = 0;
        int high = res.length -1;
        while (low < high) {
            swap(res, high, low + ((int)(Math.random() * (high - low + 1))));
            int p = partition(res, low, high);
            if (p == k) {
                break ;
            } else if (p > k) {
                high = p -1;
            } else {
                low = p + 1;
            }
        }
    }

    private int partition(int[] arr, int low, int high) {
        int less = low - 1;
        int current = low;
        int more = high;
        while (current < more) {
            if (arr[current] < arr[high]) {
                swap(arr, current++, ++less);
            } else if (arr[current] > arr[high]) {
                swap(arr, current, --more);
            } else {
                current++;
            }
        }
        swap(arr, more, high);
        return more;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 5, 9}, {10, 11, 13}, {12, 13, 15}};
        KthSmallest obj = new KthSmallest();
        int res = obj.kthSmallest(matrix, 8);
        System.out.println(res);
    }
}
