package com.leetcode.algorithm.bit;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @ ClassName SingleNumbers
 * @ author lskyline
 * @ 2021/5/29 20:09
 * @ Version: 1.0
 */
public class SingleNumbers {
    /*
     * 数组中数字出现的次数
     * 1) Map统计
     * 2) 异或
     */
    public int[] singleNumbers(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        int[] res = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        for (int i =0, index = 0; i < nums.length; i++) {
            if (map.get(nums[i]) == 1) {
                res[index++] = nums[i];
            }
        }
        return res;
    }

    public int[] singleNumbers02(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        int ret = 0;
        for (int n : nums) {
            ret ^= n;
        }
        int h = 1;
        while ((ret & h) == 0) {
            h <<= 1;
        }
        int a = 0;
        int b = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((h & nums[i]) == 0) {
                a ^= nums[i];
            } else {
                b ^= nums[i];
            }
        }
        return new int[]{a, b};
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4, 1, 4, 6};
        SingleNumbers obj = new SingleNumbers();
        int[] res = obj.singleNumbers02(arr);
        System.out.println(Arrays.toString(res));
    }
}
