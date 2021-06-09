package com.leetcode.algorithm.stack;

import java.util.Scanner;
import java.util.Stack;

/**
 * @ ClassName SortStackByStack
 * @ author lskyline
 * @ 2021/6/9 23:00
 * @ Version: 1.0
 */
public class SortStackByStack {
    /*
     * 栈实现栈的排序
     */
    public static void sortStackByStack(Stack<Integer> stack) {
        Stack<Integer> help = new Stack<>();
        while (!stack.isEmpty()) {
            int curVal = stack.pop();
            while (!help.isEmpty() && curVal > help.peek()) {
                stack.push(help.pop());
            }
            help.push(curVal);
        }

        while (!help.isEmpty()) {
            stack.push(help.pop());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            arr[i] = sc.nextInt();
        }
        Stack<Integer> stack = new Stack<>();
        for (int num : arr) {
            stack.push(num);
        }
        sortStackByStack(stack);
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }


}
