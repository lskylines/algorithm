package com.leetcode.algorithm.search;

/**
 * @ ClassName Search
 * @ author lskyline
 * @ 2021/4/24 23:20
 * @ Version: 1.0
 */
public class Search {
    /*
     * 搜索旋转排序数组
     */
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        if (nums.length == 1) {
            return nums[0] == target ? 0 : -1;
        }
        int low = 0;
        int high = nums.length -1;
        while (low <= high) {
            int mid = low + ((high - low)>>1);
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] >= nums[low]) {
                if (target >= nums[low] && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (target > nums[mid] && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4,5,6,7,0,1,2};
        Search obj = new Search();
        int res = obj.search(arr, 3);
        System.out.println(res);
    }
}

