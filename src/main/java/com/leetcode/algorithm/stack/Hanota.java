package com.leetcode.algorithm.stack;

/**
 * @ ClassName Hanota
 * @ author lskyline
 * @ 2021/4/22 10:23
 * @ Version: 1.0
 */
public class Hanota {
    /*
     * 汉诺塔
     */
    public static void hanota(int n, char A, char B, char C) {
        if (n == 1) {
            System.out.println("从" + A + "移动到" + C);
            return ;
        }
        hanota(n-1, A, C, B);
        System.out.println("从" + A + "移动到" + C);
        hanota(n-1, B ,A, C);
    }

    public static void main(String[] args) {

    }
}
