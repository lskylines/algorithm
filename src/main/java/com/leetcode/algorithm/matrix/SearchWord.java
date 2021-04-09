package com.leetcode.algorithm.matrix;

/**
 * @ ClassName SearchWord
 * @ author lskyline
 * @ 2021/4/9 10:48
 * @ Version: 1.0
 */
public class SearchWord {
    /**
     * Word Search
     * The word can be constructed from letters of sequentially adjacent cells,
     * where adjacent cells are horizontally or vertically neighboring.
     * The same letter cell may not be used more than once.
     */

    private int[][] d = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    private boolean[][] visit;
    private int m;
    private int n;
    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        visit = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (searchWord(board, word, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean searchWord(char[][] board, String word, int index, int startX, int startY) {
        if (index == word.length() - 1) {
            return board[startX][startY] == word.charAt(index);
        }
        if (board[startX][startY] == word.charAt(index)) {
            visit[startX][startY] = true;
            for (int i = 0; i < 4; i++) {
                int newX = startX + d[i][0];
                int newY = startY + d[i][1];
                if (newX >=0 && newX < m && newY >= 0 && newY < n && !visit[newX][newY]
                        && searchWord(board, word, index+1, newX, newY)) {
                    return true;
                }
            }
            visit[startX][startY] = false;
        }
        return false;
    }

    public static void main(String[] args) {
        SearchWord obj = new SearchWord();
        char[][] board = {{ 'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCCED";
        boolean flag = obj.exist(board, word);
        System.out.println(flag);
    }
}
