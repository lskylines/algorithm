package com.leetcode.algorithm.array;

/**
 * @ ClassName CanJump
 * @ author lskyline
 * @ 2021/4/25 21:54
 * @ Version: 1.0
 */
public class CanJump {
    /*
     * 跳跃游戏 TODO + 1
     */
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int rightmost = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i <= rightmost) {
                rightmost = Math.max(i + nums[i], rightmost);
            }
            if (rightmost >= nums.length -1) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 1, 0, 4};
        CanJump obj = new CanJump();
        boolean flag = obj.canJump(nums);
        System.out.println(flag);
    }
}
