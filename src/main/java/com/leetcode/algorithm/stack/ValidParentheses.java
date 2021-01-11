package com.leetcode.algorithm.stack;

import java.util.Stack;

/**
 * @author lskyline
 * @ 2021/1/11 23:54
 *
 */
public class ValidParentheses {

    /*
     *  Description : leetcode20  Valid Parentheses
     *  Given a string s containing just the characters '(', ')', '{', '}', '[' and ']',
     *  determine if the input string is valid.
     */

    /**
     * 解题思路:
     *         如果遇到( [ { 字符串，则push进栈中，否则将栈中的值取出，看是否匹配，
     *         全部字符串遍历完，如果栈为空，说明符合
     * @param s 字符串
     * @return boolean
     */
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c: s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char stackOfChar = stack.pop();
                boolean b1 = stackOfChar != '(' && c == ')';
                boolean b2 = stackOfChar != '[' && c == ']';
                boolean b3 = stackOfChar != '{' && c == '}';
                if (b1 || b2 || b3) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    /**
     * 解题思路:
     *          如果字符(,[,{,则将匹配的另一半),],}放入栈中， 当不是(,[,{时，判断栈是否为空或者栈中的元素是否等于字符
     *          如果字符串到末尾，判断栈是否为空
     *          1. 如果栈为空，则符合
     *          2. 如果栈不为空，则不符合
     * @param s
     * @return
     */
    public boolean isValid02(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '[') {
                stack.push(']');
            } else if (c == '{') {
                stack.push('}');
            } else {
                if (stack.isEmpty() || stack.pop() != c) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
