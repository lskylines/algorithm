package com.leetcode.algorithm.backtracking;

/**
 * @ ClassName Solve
 * @ author lskyline
 * @ 2021/5/1 10:51
 * @ Version: 1.0
 */
public class Solve {
    /*
     * 被围绕的区域
     */
    public void solve(char[][] board) {
        if (board == null || board.length == 0) {
            return ;
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                boolean isEdge = i == 0 || j == 0 || i == board.length -1 || j == board[0].length - 1;
                if (isEdge && board[i][j] == 'o') {
                    dfs(i, j, board);
                }
            }
        }


        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'o') {
                    board[i][j] = 'x';
                }
                if (board[i][j] == 'A') {
                    board[i][j] = 'o';
                }
            }
        }
        printMatrix(board);

    }


    private void printMatrix(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + "\t");
            }
            System.out.println();
        }
    }

    private void dfs(int i, int j, char[][] board) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return ;
        }
        if (board[i][j] != 'o') {
            return ;
        }
        board[i][j] = 'A';
        dfs(i -1, j , board);
        dfs(i + 1, j, board);
        dfs(i, j -1, board);
        dfs(i, j + 1, board);
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{{'x', 'x', 'x', 'x'},
                {'x', 'o', 'o', 'x'},
                {'x', 'x', 'o', 'x'},
                {'x', 'o', 'x', 'x'},
        };
        Solve obj = new Solve();
        obj.solve(board);

    }
}
