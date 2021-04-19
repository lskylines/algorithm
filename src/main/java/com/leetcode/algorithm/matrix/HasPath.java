package com.leetcode.algorithm.matrix;

/**
 * @ ClassName HasPath
 * @ author lskyline
 * @ 2021/4/9 10:14
 * @ Version: 1.0
 */
public class HasPath {
    /**
     * 矩阵中的路径
     * 回溯法
     */
    private int[][] d = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    private int rows;
    private int cols;
    private boolean[][] visited;

    public boolean hasPath(String val,int rows, int cols, String path) {
        if (rows == 0 || cols == 0) {
            return false;
        }
        this.rows = rows;
        this.cols = cols;
        int index = 0;
        char[] array = val.toCharArray();
        char[] pathList = path.toCharArray();
        char[][] matrix = buildMatrix(array);
        printMatrix(matrix);

        visited = new boolean[rows][cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (hasPathCore(matrix, pathList, index, row, col)) {
                    return true;
                }
            }
        }
        return false;
    }

    private char[][] buildMatrix(char[] arr) {
        char[][] matrix = new char[rows][cols];
        for (int i = 0, idx = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = arr[idx++];
            }
        }
        return matrix;
    }

    private void printMatrix(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public boolean hasPathCore(char[][] matrix, char[] pathList, int index, int row, int col) {
        System.out.println(matrix[row][col] + "============>" + pathList[index]);
        if (index == pathList.length - 1) {
            System.out.println("&&&&&&&&&&&&&&&&&&&");
            System.out.println(matrix[row][col] + ":" + pathList[index]);
            return matrix[row][col] == pathList[index];
        }

        if (matrix[row][col] == pathList[index]) {
            visited[row][col] = true;
            for (int i = 0; i < d.length; i++) {
                int newRow = row + d[i][0];
                int newCol = col + d[i][1];
                if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && !visited[newRow][newCol]
                    && hasPathCore(matrix, pathList, index + 1, newRow, newCol)) {
                    return true;
                }
            }
            visited[row][col] = false;
        }
        return false;
    }

    public static void main(String[] args) {
        HasPath obj = new HasPath();
        String val = "ABCESFCSADEE";
        String path = "BFS";
        boolean flag = obj.hasPath(val,3, 4, path);
        System.out.println(flag);
    }
}
