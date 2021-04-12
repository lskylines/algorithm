package com.leetcode.algorithm.array;

import com.leetcode.algorithm.basic.GenerateData;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ ClassName PrintMatrix
 * @ author lskyline
 * @ 2021/4/12 12:19
 * @ Version: 1.0
 */
public class PrintMatrix {
    /**
     * 顺时针打印矩阵
     */
    public List<Integer> printMatrix(int[] arr,int rows, int cols) {
        if (arr == null || arr.length == 0) {
            return new ArrayList<>();
        }
        int[][] matrix = buildMatrix(arr, rows, cols);
        int row = 0;
        int col = 0;
        int dRow = matrix.length - 1;
        int dCol = matrix[0].length - 1;
        List<Integer> matrixArr = new ArrayList<>();
        while (row <= dRow && col <=dCol) {
            matrixArr.addAll(returnMatrix(matrix, row++, col++, dRow--, dCol--));
        }
        return matrixArr;
    }

    public List<Integer>  returnMatrix(int[][] matrix, int row, int col, int rows, int cols) {
        List<Integer> arr = new ArrayList<>();
        if (row == rows) {
            for (int i = col; i <= cols; i++) {
                arr.add(matrix[row][i]);
            }
        } else if (col == cols) {
            for (int i = row; i <= rows; i++) {
                arr.add(matrix[i][col]);
            }
        } else {
            int curRow = row;
            int curCol = col;
            while (curCol != cols) {
                arr.add(matrix[row][curCol]);
                curCol++;
            }
            while (curRow != rows) {
                arr.add(matrix[curRow][cols]);
                curRow++;
            }
            while (curCol != col) {
                arr.add(matrix[rows][curCol]);
                curCol--;
            }
            while (curRow != row) {
                arr.add(matrix[curRow][col]);
                curRow--;
            }
        }
        return arr;
    }


    public int[][] buildMatrix(int[] arr, int row, int col) {
        int[][] matrix = new int[row][col];
        for (int i = 0, index = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrix[i][j] = arr[index++];
            }
        }
        return matrix;
    }

    public static void main(String[] args) {
        int[] arr = GenerateData.generateOrder(16);
        PrintMatrix obj = new PrintMatrix();
        List<Integer> res = obj.printMatrix(arr, 4, 4);
        System.out.println(res);
    }
}
