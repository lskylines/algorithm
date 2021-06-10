package com.leetcode.algorithm.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @ ClassName GetNearLess
 * @ author lskyline
 * @ 2021/6/10 0:15
 * @ Version: 1.0
 */
public class GetNearLess {
    /*
     * 单调栈结构进阶
     */
    public int[][] getNearLess(int[] arr) {
        int[][] res = new int[arr.length][2];
        Stack<List<Integer>> stack = new Stack<List<Integer>>();
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek().get(0)] > arr[i]) {
                List<Integer> popIs = stack.pop();
                int leftLessIndex = stack.isEmpty() ? -1 : stack.peek().get(stack.peek().size() -1);
                for (Integer popi: popIs) {
                    res[popi][0] = leftLessIndex;
                    res[popi][1] = i;
                }
            }
            if (!stack.isEmpty() && arr[stack.peek().get(0)] == arr[i]) {
                stack.peek().add(i);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                stack.push(list);
            }
        }

        while (!stack.isEmpty()) {
            List<Integer> popIs = stack.pop();
            int leftLessIndex = stack.isEmpty() ? -1 : stack.peek().get(stack.peek().size() -1);
            for (Integer popi : popIs) {
                res[popi][0] = leftLessIndex;
                res[popi][1] = -1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 1, 3, 4, 3, 5, 3, 2, 2};
        GetNearLess obj = new GetNearLess();
        int[][] results = obj.getNearLess(arr);
        for (int[] result : results) {
            System.out.println(Arrays.toString(result));
        }
    }
}
