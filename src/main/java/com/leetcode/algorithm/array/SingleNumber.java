package com.leetcode.algorithm.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @ ClassName SingleNumber
 * @ author lskyline
 * @ 2021/4/26 19:47
 * @ Version: 1.0
 */
public class SingleNumber {
    /*
     * 只出现一次的数字
     * 1) 遍历， Map存储， Key(数字) -> Value（次数)
     * 2)异或运算
     */
    public int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Map<Integer, Integer> map  = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return -1;
    }

    public int singleNumber02(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res = res ^ nums[i];
        }
        return res;
    }
}
