package com.leetcode.algorithm.num;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @ ClassName SubarraySum
 * @ author lskyline
 * @ 2021/4/29 18:28
 * @ Version: 1.0
 */
public class SubarraySum {
    /*
     * 和为K的子数组
     * 1) 暴力法
     * 2） 前缀和
     *
     */
    public int subarraySum(int[] nums, int k) {
        if (nums == null) {
            return 0;
        }
        Arrays.sort(nums);
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                if (nums[j] > k) {
                    break ;
                } else {
                    sum += nums[j];
                    if (sum == k) {
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }

    public int subarraySum02(int[] nums, int k) {
        if (nums == null) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        int pre = 0;
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            if (map.containsKey(pre - k)) {
                count += map.get(pre -k);
            }
            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }
        return count;
    }



    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1};
        SubarraySum obj = new SubarraySum();
        int res = obj.subarraySum02(nums, 2);
        System.out.println(res);
    }
}