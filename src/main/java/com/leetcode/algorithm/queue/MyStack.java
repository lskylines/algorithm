package com.leetcode.algorithm.queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author lskyline
 * @ 2021/1/11 22:56
 *
 */
public class MyStack {
    /*
     * Description : leetcode225  Implement Stack using Queues
     * Implement a last in first out (LIFO) stack using only two queues.
     * The implemented stack should support all the functions of a normal queue (push, top, pop, and empty).
     */

    private Queue<Integer> queue;

    public MyStack() {
        queue = new LinkedList<>();
    }

    public void push(int x) {
        queue.add(x);
        int size = queue.size();
        while (size -- > 1) {
            queue.add(queue.poll());
        }
    }

    public int pop() {
        return queue.remove();
    }


    public int top() {
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}
