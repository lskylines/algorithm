package com.leetcode.algorithm.dp;

/**
 * @ ClassName MinPathSum
 * @ author lskyline
 * @ 2021/4/18 19:43
 * @ Version: 1.0
 */
public class MinPathSum {
    /**
     * 矩阵的最小路径和
     */
    public int minPathSum(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null ||  matrix[0].length == 0) {
            return 0;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] dp = new int[row][col];
        dp[0][0] = matrix[0][0];
        for (int i = 1; i < row; i++) {
            dp[i][0] += dp[i-1][0] + matrix[i][0];
        }
        for (int j = 1; j < col; j++) {
            dp[0][j] = dp[0][j-1] + matrix[0][j];
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                dp[i][j] = Math.min(matrix[i][j] + dp[i-1][j], matrix[i][j] + dp[i][j-1]);
            }
        }
        return dp[row-1][col-1];
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
        int[][] matrix = new int[][]{{1, 3, 5, 9}, {8, 1, 3, 4}, {5, 0, 6, 1}, {8, 8, 4, 0}};
        int res = obj.minPathSum(matrix);
        System.out.println(res);
    }
}
