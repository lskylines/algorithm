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
     * 2) 基于Partition函数
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
        findKthSmallest(nums, nums.length / 2);
        int res = nums[nums.length / 2];
        if (checkMoreThanHalf(nums, res)) {
            return res;
        } else {
            return 0;
        }
    }

    public void findKthSmallest(int[] nums, int k) {
        int low  = 0;
        int high = nums.length -1;
        while (low < high) {
            swap(nums, low + ((int)(Math.random() * (high - low + 1))), high);
            int p = partition(nums, low, high);
            if (p == k) {
                break ;
            } else if (p > k) {
                high = p -1;
            } else {
                low = p + 1;
            }
        }
    }

    public int partition(int[] nums, int left, int right) {
        int less = left - 1;
        int more = right;
        int current = left;
        while (current < more) {
            if (nums[current] < nums[right]) {
                swap(nums, current++, ++less);
            } else if (nums[current] > nums[right]) {
                swap(nums, current, --more);
            } else {
                current++;
            }
        }
        swap(nums, more, right);
        return more;
    }

    public int moreThanHalfNum03(int[] nums) {
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

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{2,2,1,1,1,2,2};
        MoreThanHalfNum obj = new MoreThanHalfNum();
        int target = obj.moreThanHalfNum02(nums);
        System.out.println(target);
    }
}
