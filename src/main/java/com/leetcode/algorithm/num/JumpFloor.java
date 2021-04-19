package com.leetcode.algorithm.num;

/**
 * @ ClassName JumpFloor
 * @ author lskyline
 * @ 2021/4/9 9:19
 * @ Version: 1.0
 */
public class JumpFloor {
    /**
     * 跳台阶
     */
    public int jumpFloor(int n) {
        if (n <= 2) {
            return n;
        }
        int pre1 = 1;
        int pre2 = 2;
        int result = 0;
        for (int i = 2; i < n; i++) {
            result = pre1 + pre2;
            pre1 = pre2;
            pre2 = result;
        }
        return result;
    }

    public static void main(String[] args) {
        JumpFloor obj = new JumpFloor();
        int result = obj.jumpFloor(3);
        System.out.println(result);
    }
}
