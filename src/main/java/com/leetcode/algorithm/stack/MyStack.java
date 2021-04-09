package com.leetcode.algorithm.stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ ClassName MyStack
 * @ author lskyline
 * @ 2021/4/9 8:41
 * @ Version: 1.0
 */
public class MyStack {
    private Queue<Integer> queue1;
    private Queue<Integer> queue2;


    public MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    public void push(int x) {
        queue1.add(x);
    }

    public int pop() {
        if (queue1.isEmpty()) {
            throw new RuntimeException("Stack is Empty");
        }
        while (queue1.size() > 1) {
            queue2.add(queue1.poll());
        }
        int res = queue1.poll();
        swap();
        return res;
    }

    private void swap() {
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }


    public static void main(String[] args) {
        MyStack obj = new MyStack();
        obj.push(1);
        obj.push(2);
        int res = obj.pop();
        System.out.println(res + ":" + obj.pop());
    }
}
