package com.leetcode.algorithm.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ ClassName permuteUnique
 * @ author lskyline
 * @ 2021/6/1 0:24
 * @ Version: 1.0
 */
public class PermuteUnique {
    /*
     * 全排列 I
     */
    private List<List<Integer>> result = new ArrayList<>();
    private boolean[] visit;
    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null || nums.length == 0) {
            return result;
        }
        visit = new boolean[nums.length];
        int index = 0;
        traceback(nums, new ArrayList<>(), index);
        return result;
    }

    private void traceback(int[] nums, List<Integer> arr, int index) {
        if (index == nums.length) {
            result.add(new ArrayList<>(arr));
            return ;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visit[i] || (i > 0 && nums[i - 1] == nums[i] && !visit[i - 1])) {
                continue ;
            }
            visit[i] = true;
            arr.add(nums[i]);
            traceback(nums, arr, index + 1);
            visit[i] = false;
            arr.remove(arr.size() -1);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 2};
        PermuteUnique obj = new PermuteUnique();
        List<List<Integer>> results = obj.permuteUnique(nums);
        for (List<Integer> result : results) {
            System.out.println(result);
        }
    }
}
