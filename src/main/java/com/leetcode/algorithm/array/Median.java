package com.leetcode.algorithm.array;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @ ClassName Median
 * @ author lskyline
 * @ 2021/4/14 16:48
 * @ Version: 1.0
 */
public class Median {
    /*
     * 数据流中的中位数
     */
    private int N = 0;
    private Queue<Integer> left = new PriorityQueue<>((o1, o2) -> o2 - o1);
    private Queue<Integer> right = new PriorityQueue<>();
    public void Insert(Integer val) {
        if (N % 2 == 0) {
            left.add(val);
            right.add(left.poll());
        } else {
            right.add(val);
            left.add(right.poll());
        }
        N++;
    }

    public Double GetMedian() {
        if (N % 2== 0) {
            return (left.peek() + right.peek()) / 2.0;
        } else {
            return (double)right.peek();
        }
    }

    public static void main(String[] args) {
        int[] arrs = new int[]{5,2,3,4,1,6,7,0,8};
        Median obj = new Median();
        for (int arr : arrs) {
            obj.Insert(arr);
        }
        Double res = obj.GetMedian();
        System.out.println(res);
    }
}
