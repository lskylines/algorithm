package com.leetcode.algorithm.stack;

import java.util.Stack;

/**
 * @ ClassName IsPopOrder
 * @ author lskyline
 * @ 2021/4/12 13:58
 * @ Version: 1.0
 */
public class IsPopOrder {
    /*
     *  栈的压入、弹出序列
     */
    public boolean isPopOrder(int[] pushSeq, int[] popSeq) {
        int n = pushSeq.length;
        Stack<Integer> stack = new Stack<>();
        for (int pushIndex = 0, popIndex = 0; pushIndex < n; pushIndex++) {
            stack.push(pushSeq[pushIndex]);
            while (popIndex < n && !stack.isEmpty() && stack.peek() == popSeq[popIndex]) {
                stack.pop();
                popIndex++;
            }
        }
        return stack.isEmpty();
    }

}
