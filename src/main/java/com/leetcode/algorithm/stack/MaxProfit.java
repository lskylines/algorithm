package com.leetcode.algorithm.stack;

import java.util.Stack;

/**
 * @ ClassName MaxProfit
 * @ author lskyline
 * @ 2021/4/22 20:13
 * @ Version: 1.0
 */
public class MaxProfit {
    /*
     * 买卖股票的最佳时机  单调栈应用场景
     */
    public int maxProfit(int[] price) {
        if (price == null || price.length ==0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        int maxValue = 0;
        for (int i = 0; i < price.length; i++) {
            while (!stack.isEmpty() && stack.peek() > price[i]) {
                maxValue = Math.max(maxValue, stack.peek() - stack.firstElement());
                stack.pop();
            }
            stack.push(price[i]);
        }
        while (stack.size() > 1) {
            maxValue = Math.max(maxValue, stack.pop() - stack.firstElement());
        }
        return maxValue;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{7, 1, 5, 3, 6, 4};
        MaxProfit obj = new MaxProfit();
        int res = obj.maxProfit(arr);
        System.out.println(res);
    }

}
