package com.leetcode.algorithm.backtracking;

import netscape.security.UserTarget;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ ClassName CombinationSum
 * @ author lskyline
 * @ 2021/4/19 23:39
 * @ Version: 1.0
 */
public class CombinationSum {
    /*
     *  组合
     */
    public List<List<Integer>> combinationSum(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, new ArrayList<>(), k, 1, n);
        return res;
    }

    public List<List<Integer>> combinationSum2(int[] arr, int target) {
        List<List<Integer>> ret = new ArrayList<>();
        if (arr == null || target < 0) {
            return ret;
        }
        Arrays.sort(arr);
        backtrack(ret, new ArrayList<>(), arr, 0, target);
        return ret;
    }

    private void dfs(List<List<Integer>> res, List<Integer> list, int k, int start, int n) {
        if (list.size() == k || n <= 0) {
            if (list.size() == k && n == 0) {
                res.add(new ArrayList<>(list));
            }
            return ;
        }
        for (int i = start; i <= 4 ; i++) {
            list.add(i);
            dfs(res, list, k, i + 1, n-i);
            list.remove(list.size() - 1);
        }
    }

    private void backtrack(List<List<Integer>> res, List<Integer> cur, int[] candidates, int start, int target) {
        if (target == 0) {
            res.add(new ArrayList<>(cur));
            return ;
        }
        for (int i = start; i < candidates.length; i++) {
            if ((candidates[i] > target) || (i > start && candidates[i] == candidates[i-1])) {
                continue;
            }
            cur.add(candidates[i]);
            backtrack(res, cur, candidates, start+1, target - candidates[i]);
            cur.remove(cur.size() - 1);
        }
    }

    public static void main(String[] args) {
        CombinationSum obj = new CombinationSum();
        int[] arr = new int[]{2, 5, 2, 1, 2};
        List<List<Integer>> results = obj.combinationSum2(arr, 5);
        for (List<Integer> result : results) {
            System.out.println(result);
        }
    }
}
