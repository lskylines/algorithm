package com.leetcode.algorithm.array;

/**
 * @ ClassName MoveZero
 * @ author lskyline
 * @ 2021/2/28 20:28
 * @ Version: 1.0
 */
public class MoveZero {
    /*
     * Description : leetcode283 Move Zeroes
     * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements..
     */

    /**
     * 解题思路:
     *      遍历数组，将遍历过程中数组中不是0的放入自定义下标对应的数组位置
     * @param nums 数组
     * @return
     */
    public void moveZeroes(int[] nums) {
        int idx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[idx++] = nums[i];
            }
        }
        while(idx < nums.length) {
            nums[idx++] = 0;
        }
    }

    public void moveZeroes02(int[] nums) {
        if (nums == null || nums.length == 0) {
            return ;
        }
        int j = 0;
        for (int i =0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j++] = temp;
            }
        }
    }

    public void moveZeroes03(int[] nums) {
        if (nums == null || nums.length == 0) {
            return ;
        }
        devide(nums, 0, nums.length -1);
    }

    private void devide(int[] nums, int low, int high) {
        int less = low -1;
        int current = low;
        int more = high;
        while (current <= more) {
            if (nums[current] != 0) {
                swap(nums, ++less, current++);
            } else {
                current++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


}
