package com.leetcode.algorithm.search;

/**
 * @ ClassName SearchRange
 * @ author lskyline
 * @ 2021/4/24 23:40
 * @ Version: 1.0
 */
public class SearchRange {
    /*
     * 在排序数组中查找元素的第一个和最后一个位置
     */
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }
        if (nums.length == 0 && target == nums[0]) {
            return new int[]{0, 0};
        }
        int firstIndex = findFirstIndex(nums, target);
        int lastIndex = findLastIndex(nums, target);
        return new int[]{firstIndex, lastIndex};
    }

    private int findFirstIndex(int[] nums, int target) {
        int low = 0;
        int high = nums.length -1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (nums[mid] > target) {
                high = mid - 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                if (mid == 0 || nums[mid -1] != target) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

    private int findLastIndex(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + ((high - low)>>1);
            if (nums[mid] > target) {
                high = mid -1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                if (mid == nums.length - 1 || nums[mid + 1] != target) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            }
        }
        return -1;
    }
}
