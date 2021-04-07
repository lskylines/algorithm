package com.leetcode.algorithm.matrix;

/**
 * @ ClassName FindNumInSortedMatrix
 * @ author lskyline
 * @ 2021/4/7 18:15
 * @ Version: 1.0
 */
public class FindNumInSortedMatrix {
    //矩阵中寻找特定值
    public static boolean isContains(int[][] martix, int value) {
        if (martix == null || martix.length == 0 ||martix[0].length == 0) {
            return false;
        }
        return findNum(martix, value);
    }

    public static boolean findNum(int[][] matrix, int value) {
        int row = 0;
        int column = matrix[0].length - 1;
        int endRow = matrix.length  - 1;
        int endColumn = matrix[0].length - 1;
        while (row <= endRow && column >= 0) {
            if (matrix[row][column] > value) {
                column--;
            } else if (matrix[row][column] < value) {
                row++;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][] { { 0, 1, 2, 3, 4, 5, 6 },
                { 10, 12, 13, 15, 16, 17, 18 },
                { 23, 24, 25, 26, 27, 28, 29 },
                { 44, 45, 46, 47, 48, 49, 50 },
                { 65, 66, 67, 68, 69, 70, 71 },
                { 96, 97, 98, 99, 100, 111, 122 },
                { 166, 176, 186, 187, 190, 195, 200 },
                { 233, 243, 321, 341, 356, 370, 380 }
        };
        boolean flag = isContains(matrix, 341);
        System.out.println(flag);
    }
}
