package com.leetcode.algorithm.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @ ClassName Permute
 * @ author lskyline
 * @ 2021/4/20 0:32
 * @ Version: 1.0
 */
public class Permute {
    /*
     * 全排序
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return results;
        }
        backtrack(results, new ArrayList<>(), nums);
        return results;
    }

    private void backtrack(List<List<Integer>> results, List<Integer> help, int[] nums) {
        if (help.size() == nums.length) {
            results.add(new ArrayList<>(help));
            return ;
        }
        for (int i = 0; i < nums.length; i++) {
            if (help.contains(nums[i])) {
                continue;
            }
            help.add(nums[i]);
            backtrack(results, help, nums);
            help.remove(help.size() -1);
        }
    }

    public static void main(String[] args) {
        Permute obj = new Permute();
        int[] nums = new int[]{1, 2, 3};
        List<List<Integer>> results = obj.permute(nums);
        for (List<Integer> result : results) {
            System.out.println(result);
        }
    }
}
