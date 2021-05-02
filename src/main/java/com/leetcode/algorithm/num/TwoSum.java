package com.leetcode.algorithm.num;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @ ClassName TwoSum
 * @ author lskyline
 * @ 2021/4/22 19:14
 * @ Version: 1.0
 */
public class TwoSum {
    /*
     * 两数之和
     * 1) 暴力法
     * 2） 哈希表
     */
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return null;
        }
        int[] res = new int[2];
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    res[0] = i;
                    res[1] = j;
                }
            }
        }
        return res;
    }

    public int[] twoSum02(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return null;
        }
        int[] res = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{i , map.get(target - nums[i])};
            }
            map.put(nums[i], i);
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};
        TwoSum obj = new TwoSum();
        int[] res = obj.twoSum(nums, 9);
        System.out.println(Arrays.toString(res));
    }
}
