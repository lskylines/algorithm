package com.leetcode.algorithm.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @ ClassName Subsets
 * @ author lskyline
 * @ 2021/4/20 0:14
 * @ Version: 1.0
 */
public class Subsets {
    /*
     * 子集
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list, new ArrayList<>(), nums, 0);
        return list;
    }

    public void backtrack(List<List<Integer>> list, List<Integer> help, int[] nums, int start) {
        if (!help.isEmpty()) {
            list.add(new ArrayList<>(help));
        }
        for (int i = start; i < nums.length; i++) {
            help.add(nums[i]);
            backtrack(list, help, nums, i + 1);
            help.remove(help.size() -1);
        }
    }
    public static void main(String[] args) {
        Subsets obj = new Subsets();
        int[] nums = new int[]{1, 2, 3};
        List<List<Integer>> results = obj.subsets(nums);
        for (List<Integer> result : results) {
            System.out.println(result);
        }
    }
}
