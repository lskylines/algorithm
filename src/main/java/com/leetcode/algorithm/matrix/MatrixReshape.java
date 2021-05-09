package com.leetcode.algorithm.matrix;

/**
 * @ ClassName MatrixReshape
 * @ author lskyline
 * @ 2021/5/9 12:10
 * @ Version: 1.0
 */
public class MatrixReshape {
    /*
     * 重塑矩阵
     */
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        if (mat == null) {
            return null;
        }
        int m = mat.length;
        int n = mat[0].length;
        if (m * n != r * c) {
            return mat;
        }
        int[][] matrix = new int[r][c];
        for (int i = 0; i < m * n; i++) {
            matrix[i / c][i % c] = mat[i / n][i % n];
        }
        return matrix;
    }

}
