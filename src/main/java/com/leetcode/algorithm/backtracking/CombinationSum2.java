package com.leetcode.algorithm.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ ClassName CombinationSum2
 * @ author lskyline
 * @ 2021/6/1 1:11
 * @ Version: 1.0
 */
public class CombinationSum2 {
    /*
     * 组合总和 II
     */
    private List<List<Integer>> results = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) {
            return results;
        }
        Arrays.sort(candidates);
        int index = 0;
        traceback(candidates, target, new ArrayList<>(), index);
        return results;
    }

    private void traceback(int[] candidate, int target, List<Integer> result, int index) {
        if (target == 0) {
            results.add(new ArrayList<>(result));
            return ;
        }
        for (int i = index; i < candidate.length; i++) {
            if (candidate[i] > target) {
                break ;
            }
            if (i > index && candidate[i] == candidate[i -1]) {
                continue ;
            }
            result.add(candidate[i]);
            traceback(candidate, target - candidate[i], result, i + 1);
            result.remove(result.size() -1);
        }
    }

    public static void main(String[] args) {
        int[] candidate = new int[]{10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        CombinationSum2 obj = new CombinationSum2();
        List<List<Integer>> results = obj.combinationSum2(candidate, target);
        for (List<Integer> result : results) {
            System.out.println(result);
        }
    }
}
