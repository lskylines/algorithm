package com.leetcode.algorithm.num;

/**
 * @ ClassName Power
 * @ author lskyline
 * @ 2021/4/9 14:33
 * @ Version: 1.0
 */
public class Power {

    /**
     * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
     */
    public double Power(double x, int n) {
        boolean isNeg = false;
        if (n < 0) {
            n = -n;
            isNeg = true;
        }
        double res = power(x, n);
        return isNeg ? 1 / res : res;
    }

    private double power(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        double res = power(x, n / 2);
        res *= res;
        if (n %2 != 0) {
            res *= x;
        }
        return res;
    }
}
