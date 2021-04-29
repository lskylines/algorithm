package com.leetcode.algorithm.Strings;

import sun.font.FontRunIterator;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @ ClassName DecodeString
 * @ author lskyline
 * @ 2021/4/28 23:59
 * @ Version: 1.0
 */
public class DecodeString {
    /*
     * 字符串解码
     */
    public String decodeString(String s) {
        StringBuilder res = new StringBuilder();
        int multi = 0;
        Stack<Integer> stack_multi = new Stack<>();
        Stack<String> stack_res = new Stack<>();
        for (Character c : s.toCharArray()) {
            if (c == '[') {
                stack_multi.push(multi);
                stack_res.push(res.toString());
                multi = 0;
                res = new StringBuilder();
            } else if (c == ']') {
                StringBuilder tmp = new StringBuilder();
                int cur_multi = stack_multi.pop();
                for (int i = 0; i < cur_multi; i++) {
                    tmp.append(res);
                }
                res = new StringBuilder(stack_res.pop() + tmp);
            } else if (c >= '0' && c <= '9') {
                multi = multi * 10 + Integer.parseInt(c + "");
            } else {
                res.append(c);
            }
        }
        return res.toString();
    }



    public static void main(String[] args) {
        String s = "3[a]2[bc]";
        DecodeString obj = new DecodeString();
        String res = obj.decodeString(s);
        System.out.println(res);

    }
}
