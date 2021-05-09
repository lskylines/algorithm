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


    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 5, 9}, {10, 11, 13}, {12, 13, 15}};
        KthSmallest obj = new KthSmallest();
        int res = obj.kthSmallest(matrix, 8);
        System.out.println(res);
    }
}
