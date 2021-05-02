package com.leetcode.algorithm.num;

import java.util.Stack;

/**
 * @ ClassName AddStrings
 * @ author lskyline
 * @ 2021/5/2 10:29
 * @ Version: 1.0
 */
public class AddStrings {
    /*
     * 两个超级大数相加
     */
    public String addString(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int i = num1.length()  - 1;
        int j = num2.length() - 1;
        int carry = 0;
        while (i >= 0 || j >= 0 || carry != 0) {
            int x = i < 0 ? 0 : num1.charAt(i--) - '0';
            int y = j < 0 ? 0 : num2.charAt(j--) - '0';
            int sum = x + y + carry;
            sb.append(sum % 10);
            carry = sum / 10;
        }
        return sb.reverse().toString();
    }

    public String addString02(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry =  0;
        Stack<Integer> stack = new Stack<>();
        while (i >= 0 || j >= 0 || carry != 0) {
            int x = i < 0 ? 0 : num1.charAt(i--) - '0';
            int y = j < 0 ? 0 : num2.charAt(j--) - '0';
            int sum = x + y + carry;
            stack.push(sum % 10);
            carry = sum / 10;
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String str1 = "12367";
        String str2 = "89";
        AddStrings obj = new AddStrings();
        String res = obj.addString(str1, str2);
        System.out.println(res);
    }
}
