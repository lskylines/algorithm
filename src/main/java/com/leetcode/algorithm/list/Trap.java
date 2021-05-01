package com.leetcode.algorithm.list;

/**
 * @ ClassName Trap
 * @ author lskyline
 * @ 2021/5/1 16:09
 * @ Version: 1.0
 */
public class Trap {
    /**
     * 接雨水
     */
    public int trap(int[] height) {
        if (height.length <= 2) {
            return 0;
        }
        int maxHeight = Integer.MIN_VALUE;
        int maxIndex = 0;
        for (int i = 0; i < height.length; i++) {
            if (maxHeight < height[i]) {
                maxHeight = height[i];
                maxIndex = i;
            }
        }

        //统计左边的雨水
        int left = height[0];
        int right = 0;
        int water = 0;
        for (int i = 1; i < maxIndex; i++) {
            right = height[i];
            if (left < right) {
                left = right;
            } else {
                water += (left - right);
            }
        }
        right = height[height.length -1];
        for (int i = height.length - 2; i > maxIndex ; i--) {
            left = height[i];
            if (left > right) {
                right = left;
            } else {
                water += (right - left);
            }
        }
        return water;
    }
    public static void main(String[] args) {
        int[] height = new int[]{4, 2, 0, 3, 2, 5};
        Trap obj = new Trap();
        int res = obj.trap(height);
        System.out.println(res);
    }
}
