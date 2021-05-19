package com.leetcode.algorithm.search;

/**
 * @ ClassName SearchInsert
 * @ author lskyline
 * @ 2021/5/19 16:25
 * @ Version: 1.0
 */
public class SearchInsert {
    /*
     * 搜索插入位置
     * 1)二分查找
     */
    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (nums[mid] >= target) {
                if (mid == 0 || nums[mid -1] < target) {
                    return mid;
                }
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return nums.length;
    }
}
