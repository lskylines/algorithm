package com.leetcode.algorithm.num;

import java.util.*;

/**
 * @ ClassName ThreeSum
 * @ author lskyline
 * @ 2021/4/24 11:36
 * @ Version: 1.0
 */
public class ThreeSum {
    /*
     * 三数之和
     * 1)暴力法， 时间复杂的O(N^3)
     * 2)双指针
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        Arrays.sort(nums);
        Set<String> set = new HashSet<>();
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length -1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(nums[i]).append(nums[j]).append(nums[k]).toString();
                    if (!set.contains(sb.toString()) && nums[i] + nums[j] + nums[k] == 0) {
                        set.add(sb.toString());
                        res.add(new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[k])));
                    }
                }
            }
        }
        return res;
    }

    public List<List<Integer>> threeSum02(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0 || nums.length < 3) {
            return res;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[i],nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right -1]) {
                        right--;
                    }
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return res;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{-1,0,1,2,-1,-4};
        ThreeSum obj = new ThreeSum();
        List<List<Integer>> res = obj.threeSum02(nums);
        System.out.println(res);
    }
}
