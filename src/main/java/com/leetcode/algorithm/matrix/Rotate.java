package com.leetcode.algorithm.matrix;

/**
 * @ ClassName Rotate
 * @ author lskyline
 * @ 2021/4/25 0:51
 * @ Version: 1.0
 */
public class Rotate {
    /*
     *  旋转图像
     */
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix[0] == null || matrix.length == 0 || matrix[0].length == 0) {
            return ;
        }
        int maxRow = matrix.length - 1;
        int maxCol = matrix[0].length - 1;
        int currentRow = 0;
        int currentCol = 0;
        while (currentRow <= maxRow && currentCol <= maxCol) {
            rotateMatrix(matrix, currentRow++, currentCol++, maxRow--, maxCol--);
        }
        printMatrix(matrix);
    }


    private void rotateMatrix(int[][] arr, int currentRow, int currentCol, int maxRow, int maxCol) {
        int time = 0;
        while (time < (maxRow - currentRow)) {
            int temp = arr[currentRow][currentCol + time];
            arr[currentRow][currentCol + time] = arr[maxRow - time][currentCol];
            arr[maxRow - time][currentCol] = arr[maxRow][maxCol - time];
            arr[maxRow][maxCol - time] = arr[currentRow + time][maxCol];
            arr[currentRow + time][maxCol] = temp;
            time++;
        }

    }

    public void printMatrix(int[][] matrix)  {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        Rotate obj = new Rotate();
        obj.rotate(arr);

    }


}
