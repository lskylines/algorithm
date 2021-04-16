package com.leetcode.algorithm.matrix;

import java.util.Arrays;
import java.util.Stack;


/**
 * @ ClassName MaxRecSize
 * @ author lskyline
 * @ 2021/4/16 11:59
 * @ Version: 1.0
 */
public class MaxRecSize {
    /*
     * 最大矩形
     */
    public int maxRecSize(int[][] matrix) {
        if (matrix == null || matrix.length ==0 || matrix[0].length == 0) {
            return 0;
        }
        int[] res = new int[matrix[0].length];
        int maxRec = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                res[j] = matrix[i][j] == 0 ? 0 : res[j] + 1;
            }
            System.out.println(Arrays.toString(res));
            maxRec = Math.max(maxRec, maxRecFromBottom(res));
        }
        return maxRec;
    }

    public int maxRecFromBottom(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[stack.peek()] >= height[i]) {
                int j = stack.pop();
                int k = stack.isEmpty() ? -1 : stack.peek();
                int curArea = (i - k -1) * height[j];
                maxArea = Math.max(maxArea, curArea);
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int j = stack.pop();
            int k = stack.isEmpty() ? -1 : stack.peek();
            int curArea = (height.length - k -1) * height[j];
            maxArea = Math.max(maxArea, curArea);
        }
        return maxArea;
    }

    public static void main(String[] args) {
        MaxRecSize obj = new MaxRecSize();
        int[][] matrix = new int[][]{{1, 0, 1, 0, 0}, {1, 0, 1, 1, 1}, {1, 1, 1, 1, 1}, {1, 0, 0, 1, 0}};
        int maxSize = obj.maxRecSize(matrix);
        System.out.println(maxSize);
    }
}
