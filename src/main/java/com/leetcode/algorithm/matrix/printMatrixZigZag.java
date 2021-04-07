package com.leetcode.algorithm.matrix;

/**
 * @ ClassName printMatrixZigZag
 * @ author lskyline
 * @ 2021/4/7 12:33
 * @ Version: 1.0
 */
public class printMatrixZigZag {
    //之字形打印矩阵
    public static void printMatrixZigZag(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return ;
        }
        int tR = 0;
        int tC = 0;
        int dR = 0;
        int dC = 0;
        int endR = matrix.length - 1;
        int endC = matrix[0].length - 1;
        boolean fromUp =  false;
        while (tR != endR + 1) {
            printLevel(matrix, tR, tC, dR, dC, fromUp);
            tR = tC == endC ? tR + 1 : tR;
            tC = tC == endC ? tC : tC + 1;
            dC = dR == endR ? dC + 1 : dC;
            dR = dR == endR ? dR : dR + 1;
            fromUp = !fromUp;
        }
    }

    public static void printLevel(int[][] matrix, int tR, int tC, int dR, int dC, boolean f) {
        if (f) {
            while (tR != dR + 1) {
                System.out.println(matrix[tR++][tC--]);
            }
        } else {
            while (dR != tR -1 ) {
                System.out.println(matrix[dR--][dC++]);
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        printMatrixZigZag(matrix);
    }
}
