package com.leetcode.algorithm.array;

import java.util.Arrays;

/**
 * @ ClassName MoreThanHalfNum
 * @ author lskyline
 * @ 2021/4/14 14:32
 * @ Version: 1.0
 */
public class MoreThanHalfNum {
    /*
     * 数组中出现次数超过一半的数字
     * 1) 排序后的中位数
     * 2) 基于Partition函数 todo
     * 3) 根据数组特点，相同+1， 不同-1
     */
    public int moreThanHalfNum(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    public int moreThanHalfNum02(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int result = nums[0];
        int times = 1;
        for (int i = 1; i < nums.length; i++) {
            if (times == 0) {
                result = nums[i];
                times = 1;
            }else if (nums[i] != result) {
                times--;
            } else {
                times++;
            }
        }
        if (checkMoreThanHalf(nums, result)) {
            return result;
        } else {
            return 0;
        }
    }

    public boolean checkMoreThanHalf(int[] nums, int result) {
        int times = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == result) {
                times++;
            }
        }
        return times > nums.length / 2;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{2,2,1,1,1,2,2};
        MoreThanHalfNum obj = new MoreThanHalfNum();
        int target = obj.moreThanHalfNum02(nums);
        System.out.println(target);
    }
}
