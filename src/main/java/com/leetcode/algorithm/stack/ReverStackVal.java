package com.leetcode.algorithm.stack;

import java.util.Stack;


public class ReverStackVal {
    /**
     * 一个栈依次压入1,2,3,4,5, 那么从栈顶到栈底分别为5,4,3,2,1,
     * 将这个栈转置后，从栈顶到栈底为1， 2， 3， 4 ，5
     * 实现栈中元素你虚，只能使用递归来实现，不能使用其他数据结构
     */

    private Stack<Integer> stack;

    public ReverStackVal() {
        stack = new Stack<>();
    }

    public int getAndRemoveLastElement(Stack<Integer> stack) {
        int result = stack.pop();
        if (stack.isEmpty()) {
            return result;
        } else {
            int last = getAndRemoveLastElement(stack);
            stack.push(result);
            return last;
        }
    }

        public static void main(String[] args) {
            Stack<Integer> stack = new Stack<>();
            stack.push(1);
            stack.push(2);
            stack.push(3);
            ReverStackVal obj = new ReverStackVal();
            while (!stack.isEmpty()) {
                int res = obj.getAndRemoveLastElement(stack);
                System.out.println(res);
            }
        }

}
