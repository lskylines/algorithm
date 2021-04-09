package com.leetcode.algorithm.num;

/**
 * @ ClassName Fibonacci
 * @ author lskyline
 * @ 2021/4/9 9:11
 * @ Version: 1.0
 */
public class Fibonacci {
    /**
     * 斐波那契数
     * 1) 使用递归
     * 2） 使用循环
     */
    public int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
    
    public int fibonacci02(int n) {
        if (n <= 1) {
            return n;
        }
        int[] fib = new int[n + 1];
        fib[0] = 0;
        fib[1] = 1;
        for (int i = 2; i <= n; i++) {
            fib[i] = fib[i -1] + fib[i-2];
        }
        return fib[n];
    }

    public static void main(String[] args) {
        Fibonacci obj = new Fibonacci();
        int res = obj.fibonacci02(4);
        System.out.println(res);
    }
}
