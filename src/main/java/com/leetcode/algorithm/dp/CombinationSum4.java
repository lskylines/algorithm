package com.leetcode.algorithm.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ ClassName CombinationSum4
 * @ author lskyline
 * @ 2021/5/12 17:13
 * @ Version: 1.0
 */
public class CombinationSum4 {
    /*
     * 组合总和 Ⅳ
     */
    private int res = 0;
    private List<List<Integer>> results = new ArrayList<>();
    public int combinationSum4(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        traceback(nums, target, new ArrayList<>());
        for (int i = 0; i < results.size(); i++) {
            System.out.println(results.get(i));
        }
        return res;
    }

    public int combinationSum402(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i >= nums[j]) {
                    dp[i] += dp[i - nums[j]];
                }
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[target];
    }


    private void traceback(int[] nums, int target, List<Integer> result) {
        if (target < 0) {
            return ;
        }
        if (target == 0) {
            results.add(new ArrayList<>(result));
            res++;
            return ;
        }
        for (int i = 0; i < nums.length; i++) {
            result.add(nums[i]);
            traceback(nums, target - nums[i], result);
            result.remove(result.size() -1);
        }

    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        CombinationSum4 obj = new CombinationSum4();
        int res = obj.combinationSum4(nums, 4);
        System.out.println(res);
    }
}
