package com.leetcode.algorithm.num;

/**
 * @ ClassName NumberOf1
 * @ author lskyline
 * @ 2021/4/19 17:42
 * @ Version: 1.0
 */
public class NumberOf1 {
    /*
     * 二进制1的个数
     */
    public int numberOf1(int n) {
        int cnt = 0;
        while (n != 0) {
            n &= (n-1);
            cnt++;
        }
        return cnt;
    }

    public static void main(String[] args) {
        NumberOf1 obj = new NumberOf1();
        int res = obj.numberOf1(9);
        System.out.println(res);
    }
}
