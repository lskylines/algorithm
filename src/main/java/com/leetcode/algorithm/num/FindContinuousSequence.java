package com.leetcode.algorithm.num;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ ClassName FindContinuousSequence
 * @ author lskyline
 * @ 2021/5/2 17:51
 * @ Version: 1.0
 */
public class FindContinuousSequence {
    /**
     * 和为s的连续正数序列
     */
    public int[][] findContinuousSequence(int target) {
        int left = 1;
        int right = 1;
        int sum = 0;
        List<int[]> result = new ArrayList<>();
        while (left <= target / 2) {
            if (sum < target) {
                sum +=right;
                right++;
            } else if (sum > target) {
                sum -= left;
                left++;
            } else {
                int[] res = new int[right-left];
                for (int i = left; i < right; i++) {
                    res[i-left] = i;
                }
                result.add(res);
                sum -= left;
                left++;
            }
        }
        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        int target = 9;
        FindContinuousSequence obj = new FindContinuousSequence();
        int[][] res = obj.findContinuousSequence(target);
        for (int i =0; i < res.length; i++) {
            System.out.println(Arrays.toString(res[i]));
        }
    }
}
