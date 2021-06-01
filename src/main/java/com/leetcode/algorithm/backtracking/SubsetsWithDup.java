package com.leetcode.algorithm.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ ClassName subsetsWithDup
 * @ author lskyline
 * @ 2021/6/1 17:58
 * @ Version: 1.0
 */
public class SubsetsWithDup {
    /*
     * 子集 II
     */
    private List<List<Integer>> results = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums == null || nums.length == 0) {
            return results;
        }
        Arrays.sort(nums);
        traceback(nums, 0, new ArrayList<>());
        return results;
    }

    private void traceback(int[] nums, int index, List<Integer> arr) {
        results.add(new ArrayList<>(arr));
        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i -1]) {
                continue;
            }
            arr.add(nums[i]);
            traceback(nums, i + 1, arr);
            arr.remove(arr.size() - 1);
        }
    }

}
