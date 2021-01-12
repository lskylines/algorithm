package com.leetcode.algorithm.stack;

import java.util.Stack;

/**
 * @author lskyline
 * @ 2021/1/12 22:28
 *
 */
public class DailyTemperatures {
    /*
     *  Description : LeetCode 739
     *  Given a list of daily temperatures T, return a list such that, for each day in the input,
     *  tells you how many days you would have to wait until a warmer temperature.
     *  If there is no future day for which this is possible, put 0 instead.
     *
     */

    /**
     * 解题思路:
     *          将当前要比较的元素与其之后的元素比较大小
     *          如果发现比当前元素温度大的，取出两个温度间距，保存进数组中
     *          退出内层循环，外层循环继续，进行下一个数比较
     * @param T 输入的温度
     * @return int
     */
    public int[] dailyTemperatures(int[] T) {
        //保存数组中元素下一个比他大的元素的距离
        int[] array = new int[T.length];
        for (int i = 0; i < T.length; i++) {
            for (int j = i + 1; j < T.length; j++) {
                if (T[j] > T[i]) {
                    array[i] = j - i;
                    break ;
                }
            }
        }
        return array;
    }

    /**
     * 解题思路:
     *          使用栈，如果当前遍历的数比栈顶元素的值大，说明下一个比他大的数就时当前数
     * @param T 输入的温度
     * @return
     */
    public int[] dailyTemperatures02(int[] T) {
        //保存数组中元素下一个比他大的元素的距离
        int[] array = new int[T.length];
        Stack<Integer> stack = new Stack<>();
        for (int currentIndex = 0; currentIndex < T.length; currentIndex++) {
            while (!stack.isEmpty() && T[currentIndex] > T[stack.peek()]) {
                int preIndex = stack.pop();
                array[preIndex] = currentIndex - preIndex;
            }
            stack.push(currentIndex);
        }
        return array;
    }

    public static void main(String[] args) {
        int[] T = new int[]{73, 74, 75, 71, 69, 72, 76, 73};
        int[] array = new DailyTemperatures().dailyTemperatures(T);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
