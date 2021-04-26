package com.leetcode.algorithm.matrix;

import java.util.Stack;

/**
 * @ ClassName LargestRectangleArea
 * @ author lskyline
 * @ 2021/4/26 9:59
 * @ Version: 1.0
 */
public class LargestRectangleArea {
    /*
     * 柱状图中最大的矩形
     * 1) 遍历、统计最小高度 * 宽度
     * 2)单调栈 (小 -> 大)
     */
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        int ans = 0;
        for (int left = 0; left < heights.length; left++) {
            int minHeight = Integer.MAX_VALUE;
            for (int right = left; right < heights.length; right++) {
                minHeight = Math.min(minHeight, heights[right]);
                ans = Math.max(ans, minHeight * (right - left + 1));
            }
        }
        return ans;
    }

    public int largestRectangleArea02(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                int j = stack.pop();
                int k = stack.isEmpty() ? -1 : stack.peek();
                int curArea = heights[j] * (i - k -1);
                maxArea = Math.max(maxArea, curArea);
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int j = stack.pop();
            int k = stack.isEmpty() ? -1 : stack.peek();
            int curArea = heights[j] * (heights.length - k - 1);
            maxArea = Math.max(maxArea, curArea);
        }
        return maxArea;
    }



    public static void main(String[] args) {
        int[] arr = new int[]{2, 1, 5, 6, 2, 3};
        LargestRectangleArea obj = new LargestRectangleArea();
        int res = obj.largestRectangleArea(arr);
        System.out.println(res);
    }

}
