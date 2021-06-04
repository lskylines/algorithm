package com.leetcode.algorithm.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @ ClassName MinPathSum
 * @ author lskyline
 * @ 2021/4/18 19:43
 * @ Version: 1.0
 */
public class MinPathSum {
    /**
     * 矩阵的最小路径和
     * 1) 二维数组的动态规划
     * 2） 一维数组的动态规划
     * 3） 原数组上进行的DP
     * 4） 递归 + 记忆化
     */

    private Map<String, Integer> map = new HashMap<>();

    public int minPathSum(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] dp = new int[rows][cols];
        for (int i =0;i < rows; i++) {
            for (int j =0; j < cols; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = matrix[0][0];
                } else if (i == 0) {
                    dp[i][j] = dp[i][j -1] + matrix[i][j];
                } else if (j == 0) {
                    dp[i][j] = dp[i-1][j] + matrix[i][j];
                } else {
                    dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + matrix[i][j];
                }
            }
        }
        printMatrix(dp);
        return dp[rows -1][cols -1];
    }

    public int minPathSum02(int[][] matrix) {
        if (matrix == null || matrix[0] == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[] dp = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    dp[j] = matrix[i][j];
                } else if (i == 0) {
                    dp[j] = dp[j - 1] + matrix[i][j];
                } else if (j == 0) {
                    dp[j] = dp[j] + matrix[i][j];
                } else {
                    dp[j] = Math.min(dp[j], dp[j - 1]) + matrix[i][j];
                }
            }
            System.out.println(Arrays.toString(dp));
        }
        return dp[n - 1];
    }

    public int minPathSum03(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null ||  matrix[0].length == 0) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j ==0) {
                    continue;
                }
                if (i == 0) {
                    matrix[i][j] += matrix[i][j - 1];
                } else if (j == 0) {
                    matrix[i][j] += matrix[i-1][j];
                } else {
                    matrix[i][j] = Math.min(matrix[i][j] + matrix[i-1][j], matrix[i][j] + matrix[i][j-1]);
                }
            }
        }
        return matrix[m-1][n-1];
    }


    public int minPathSum04(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        return minPathSum(matrix, matrix.length - 1, matrix[0].length -1);
    }

    public int minPathSum(int[][] matrix, int row, int col) {
        if (row == 0 && col == 0) {
            return matrix[row][col];
        }
        String key = row + "_" + col;
        if (map.containsKey(key)) {
            return map.get(key);
        }
        int res  =0 ;
        if (row == 0) {
            res =  matrix[row][col] + minPathSum(matrix, row, col-1);
        } else if (col == 0) {
            res =  matrix[row][col] + minPathSum(matrix, row-1, col);
        } else {
            res = matrix[row][col] += Math.min(minPathSum(matrix, row, col - 1), minPathSum(matrix, row-1, col));
        }
        map.put(key, res);
        return res;
    }


    public void printMatrix(int[][] dp) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        MinPathSum obj = new MinPathSum();
        int[][] matrix = new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        int res = obj.minPathSum02(matrix);
        System.out.println(res);
    }
}
