package com.leetcode.algorithm.dp;

import java.util.*;

/**
 * @ ClassName MinimumTotal
 * @ author lskyline
 * @ 2021/4/19 20:03
 * @ Version: 1.0
 */
public class MinimumTotal {
    /*
     * 三角形最小路径和
     */
    private Map<String, Integer> map = new HashMap<>();
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }
        return minimumTotal(triangle, 0, 0 , triangle.size());
    }

    public int minimumTotal(List<List<Integer>> triangle, int row, int col, int total) {
        if (row >= total || col >= total) {
            return 0;
        }
        String key = row + "_" + col;
        if (map.containsKey(key)) {
            return map.get(key);
        }
        int left = minimumTotal(triangle, row + 1, col, total);
        int right = minimumTotal(triangle, row + 1, col+1, total);

        int res =  triangle.get(row).get(col) + Math.min(left, right);
        map.put(key, res);
        return res;
    }

    public int minimumTotal02(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }
        int[][] dp = new int[triangle.size() + 1][triangle.size() + 1];
        for (int i = triangle.size() -1; i >= 0; i--) {
            for (int j =0; j < triangle.get(i).size(); j++) {
                dp[i][j] = Math.min(dp[i+1][j], dp[i+1][j+1]) + triangle.get(i).get(j);
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Arrays.asList(2));
        triangle.add(Arrays.asList(3, 4));
        triangle.add(Arrays.asList(6, 5, 7));
        triangle.add(Arrays.asList(4, 1, 8, 3));
        MinimumTotal obj = new MinimumTotal();
        int res = obj.minimumTotal02(triangle);
        System.out.println(res);

    }
}
