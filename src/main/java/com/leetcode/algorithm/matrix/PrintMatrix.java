package com.leetcode.algorithm.matrix;

/**
 * @ ClassName PrintMatrix
 * @ author lskyline
 * @ 2021/4/7 12:04
 * @ Version: 1.0
 */
public class PrintMatrix {
    //顺时针打印矩阵
    public static void printMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return ;
        }
        int tR = 0;
        int tC = 0;
        int dR = matrix.length - 1;
        int dC = matrix[0].length - 1;
        while (tR <= dR && tC <= dC) {
            printLevel(matrix, tR++, tC++, dR--, dC--);
        }
    }

    public static void printLevel(int[][] matrix, int tR, int tC, int dR, int dC)  {
        if (tR == dR) {
            for (int i = tC; i <= dC; i++) {
                System.out.println(matrix[tR][i]);
            }
        } else if (tC == dC) {
            for (int i = tR; i <= dR; i++) {
                System.out.println(matrix[i][tC]);
            }
        } else {
            int curC = tC;
            int curR = tR;
            while (curC != dC) {
                System.out.println(matrix[tR][curC++]);
            }
            while (curR != dR) {
                System.out.println(matrix[curR++][dC]);
            }
            while (curC != tC) {
                System.out.println(matrix[dR][curC--]);
            }
            while (curR != tR) {
                System.out.println(matrix[curR--][tC]);
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        printMatrix(matrix);
    }
}
