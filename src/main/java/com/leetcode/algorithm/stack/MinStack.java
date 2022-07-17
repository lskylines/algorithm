package com.leetcode.algorithm.stack;

import java.util.Objects;
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
     * 解题思路:
     * 1. 采用一个最小栈保存比较出来的最小值
     *  压入数据new_number时，如果最小栈为空，直接压入new_number, 如果最小栈不为空，则判断最小栈顶部数据与new_number谁更小，进行压入
     */
    private Stack<Integer> STACK;
    private Stack<Integer> MIN_STACK;
    private Integer MIN_VALUE;

    public MinStack() {
        STACK = new Stack<>();
        MIN_STACK = new Stack<>();
        MIN_VALUE = Integer.MAX_VALUE;
    }

    public void push(int x) {
        STACK.push(x);
        MIN_VALUE = Math.min(MIN_VALUE, x);
        MIN_STACK.push(MIN_VALUE);
    }

    public void pop() throws IllegalAccessException {
        if (STACK.isEmpty()) {
            throw new IllegalAccessException("stack is empty");
        }
        STACK.pop();
        MIN_STACK.pop();
        //等最小栈顶元素弹出后，再将最小栈中栈顶元素取出，对最小值MIN_VALUE进行维护
        MIN_VALUE = MIN_STACK.isEmpty() ? Integer.MAX_VALUE : MIN_STACK.peek();

    }

    public int top() throws IllegalAccessException {
        if (MIN_STACK.isEmpty()) {
            throw new IllegalAccessException("min stack is empty");
        }
        return STACK.peek();
    }

    public int getMin() {
        return MIN_STACK.peek();
    }
}
