package com.leetcode.algorithm.Heap;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @ ClassName LastStoneWeight
 * @ author lskyline
 * @ 2021/6/3 23:35
 * @ Version: 1.0
 */
public class LastStoneWeight {
    /*
     * 最后一块石头的重量
     * 1) 大顶堆
     */
    public int lastStoneWeight(int[] stones) {
        if (stones == null || stones.length == 0) {
            return 0;
        }
        Queue<Integer> maxHeap = new PriorityQueue<Integer>((o1, o2) -> o2 - o1);
        for (int i = 0; i < stones.length; i++) {
            maxHeap.offer(stones[i]);
        }

        while (maxHeap.size() != 1) {
            int a = maxHeap.poll();
            int b = maxHeap.poll();
            maxHeap.offer(a - b);
        }
        return maxHeap.poll();
    }

    public static void main(String[] args) {
        int[] arr = new int[] {2, 7, 4, 1, 8 , 1};
        LastStoneWeight obj = new LastStoneWeight();
        int res = obj.lastStoneWeight(arr);
        System.out.println(res);
    }
}
