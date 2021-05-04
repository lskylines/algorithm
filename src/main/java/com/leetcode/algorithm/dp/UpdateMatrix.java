package com.leetcode.algorithm.dp;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @ ClassName UpdateMatrix
 * @ author lskyline
 * @ 2021/5/4 12:47
 * @ Version: 1.0
 */
public class UpdateMatrix {
    /*
     * 01 矩阵
     * 1) 暴力法
     * 2) 动态规划
     */
    public int[][] updateMatrix(int[][] matrix) {
        Queue<int[]> queue = new LinkedList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                } else {
                    matrix[i][j] = -1;
                }
            }
        }



        int[][] d = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            int x = point[0];
            int y = point[1];
            for (int i = 0; i < d.length; i++) {
                int newX = x + d[i][0];
                int newY = y + d[i][1];
                if (newX >= 0 && newX < m && newY >= 0 && newY < n && matrix[newX][newY] == -1) {
                    matrix[newX][newY] = matrix[x][y] + 1;
                    queue.offer(new int[]{newX, newY});
                }
            }
        }
        return matrix;
    }

    public int[][] updateMatrix02(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = matrix[i][j] == 0 ? 0 : 100;
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i - 1 >= 0) {
                    dp[i][j] = Math.min(dp[i][j], dp[i-1][j] + 1);
                }
                if (j -1 >= 0) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][j-1] + 1);
                }
            }
        }

        printMatrix(matrix);


        for (int i = m - 1; i >= 0 ; i--) {
            for (int j = n - 1; j >= 0 ; j--) {
                if (i + 1 < m) {
                    dp[i][j] = Math.min(dp[i][j], dp[i+1][j] + 1);
                }
                if (j + 1 < n) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][j + 1] + 1);
                }
            }
        }
        printMatrix(matrix);
        return dp;
    }

    public void printMatrix(int[][] res) {
        for (int i = 0; i < res.length; i++) {
            System.out.println(Arrays.toString(res[i]));
        }
        System.out.println("======================");
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{0, 0, 0}, {0, 1, 0}, {1, 1, 1}};
        UpdateMatrix obj = new UpdateMatrix();
        int[][] res = obj.updateMatrix02(matrix);
        for (int i = 0; i < res.length; i++) {
            System.out.println(Arrays.toString(res[i]));
        }
    }
}
