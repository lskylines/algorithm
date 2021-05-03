package com.leetcode.algorithm.stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * @ ClassName RightWay
 * @ author lskyline
 * @ 2021/5/3 16:24
 * @ Version: 1.0
 */
public class RightWay {
    /*
     * 给定不包含重复的数组Arr, 找到位置i左边和右边离i最近且值比arr[i]小的位置
     */
    public int[][] rightWary(int[] arr) {
        int[][] result = new int[arr.length][2];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                int popNumIndex = stack.pop();
                int leftIndex = stack.isEmpty() ? -1 : stack.peek();
                result[popNumIndex][0] = leftIndex;
                result[popNumIndex][1] = i;
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int popNumIndex = stack.pop();
            int leftIndex  = stack.isEmpty() ? -1 : stack.peek();
            result[popNumIndex][0] = leftIndex;
            result[popNumIndex][1] = -1;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 4, 1, 5, 6, 2, 7};
        RightWay obj = new RightWay();
        int[][] result = obj.rightWary(arr);
        for (int i = 0; i < result.length; i++) {
            System.out.println(Arrays.toString(result[i]));
        }
    }
}
