package com.leetcode.algorithm.backtracking;

import java.util.ArrayList;
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

    public static void main(String[] args) {
        CombinationSum obj = new CombinationSum();
        List<List<Integer>> results = obj.combinationSum(3, 7);
        for (List<Integer> result : results) {
            System.out.println(result);
        }
    }
}
