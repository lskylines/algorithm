package com.leetcode.algorithm.stack;

import java.util.Stack;

/**
 * @ ClassName ValidateStackSequences
 * @ author lskyline
 * @ 2021/5/2 5:20
 * @ Version: 1.0
 */
public class ValidateStackSequences {
    /*
     * 栈的压入、弹出序列
     */
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed.length == 0 || popped.length == 0) {
            return true;
        }
        Stack<Integer> stack = new Stack<>();
        for (int pushIndex = 0, popIndex = 0; pushIndex < pushed.length; pushIndex++) {
            stack.push(pushed[pushIndex]);
            while (!stack.isEmpty() && stack.peek() == popped[popIndex]) {
                stack.pop();
                popIndex++;
            }
        }
        return stack.isEmpty();
    }
}
