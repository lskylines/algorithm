package com.leetcode.algorithm.array;

/**
 * @ ClassName mySqrt
 * @ author lskyline
 * @ 2021/5/10 22:54
 * @ Version: 1.0
 */
public class MySqrt {
    /*
     * X的平方根
     */
    public int mySqrt(int x) {
        if (x <= 1) {
            return x;
        }
        int low = 0;
        int high = (int)Math.sqrt(x);
        while (low <= high) {
            int mid = low + ((high - low ) >> 1);
            if (mid * mid == x) {
                return mid;
            } else if (mid * mid < x) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return high;
    }

    public static void main(String[] args) {
        int x = 8;
        MySqrt obj = new MySqrt();
        int res = obj.mySqrt(x);
        System.out.println(res);
    }
}
