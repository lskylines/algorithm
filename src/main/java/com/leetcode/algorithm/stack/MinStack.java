package com.leetcode.algorithm.stack;

import java.util.Stack;

/**
 * @author lskyline
 * @ 2021/1/11 23:26
 *
 */
public class MinStack {
    /*
     * Description : leetcode155  Min Stack
     * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
     */


    /**
     * 解题思路: 采用一个最小栈保存比较出来的最小值，可以确保每次从最小栈中取出的是最小的数
     */
    private Stack<Integer> stack;
    private Stack<Integer> minStack;
    private Integer minValue;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
        minValue = Integer.MAX_VALUE;
    }

    public void push(int x) {
        stack.push(x);
        minValue = Math.min(minValue, x);
        minStack.push(minValue);
    }

    public void pop() {
        stack.pop();
        minStack.pop();
        minValue = minStack.isEmpty() ? Integer.MAX_VALUE : minStack.peek();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
