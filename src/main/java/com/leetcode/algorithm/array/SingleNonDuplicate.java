package com.leetcode.algorithm.array;

/**
 * @ ClassName SingleNonDuplicate
 * @ author lskyline
 * @ 2021/5/10 23:23
 * @ Version: 1.0
 */
public class SingleNonDuplicate {
    /*
     * 有序数组中的单一元素
     * 1) 暴力法
     * 2） 异或
     */
    public int singleNonDuplicate(int[] nums) {
        for (int i = 0; i < nums.length - 1; i += 2) {
            if (nums[i] != nums[i + 1]) {
                return nums[i];
            }
        }
        return nums[nums.length - 1];
    }

    public int singleNonDuplicate02(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res ^= nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 1, 2, 3, 3, 4, 4, 8, 8};
        SingleNonDuplicate obj = new SingleNonDuplicate();
        int res = obj.singleNonDuplicate(arr);
        System.out.println(res);
    }
}
