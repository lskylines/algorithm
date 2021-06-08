package com.leetcode.algorithm.queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ ClassName MyStack02
 * @ author lskyline
 * @ 2021/6/8 21:05
 * @ Version: 1.0
 */
public class MyStack02 {
    /*
     * 用队列实现栈
     */
    private Queue<Integer> q1;
    private Queue<Integer> q2;

    public MyStack02() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    public void push(int x) {
        q2.offer(x);
        while (!q1.isEmpty()) {
            q2.offer(q1.poll());
        }
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }

    public int pop() {
        if (q1.isEmpty()) {
            return -1;
        }
        return q1.poll();
    }

    public int top() {
        if (q1.isEmpty()) {
            return -1;
        }
        return q1.peek();
    }
}
