package com.leetcode.algorithm.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @ ClassName GenerateParenthesis
 * @ author lskyline
 * @ 2021/4/24 22:03
 * @ Version: 1.0
 */
public class GenerateParenthesis {
    /*
     * 括号生成
     * 1)暴力法
     * 2) 深度优先遍历 剪枝
     */
    public List<String> generateParenthesis(int n) {
        List<String> combinations = new ArrayList<>();
        generateAll(new char[2 * n], 0, combinations);
        return combinations;
    }

    public List<String> generateParenthesis02(int n) {
        List<String> res = new ArrayList<>();
        dfs("", 0, 0, n, res);
        return res;
    }

    private void dfs(String current, int left, int right,int n, List<String> res) {
        if (left == n && right == n) {
            res.add(current);
            return ;
        }
        if (left < n) {
            dfs(current + "(",  left + 1, right, n, res);
        }
        if (right < n && left > right) {
            dfs (current + ")", left, right + 1, n, res);
        }
    }

    private void generateAll(char[] current, int pos, List<String> result) {
        if (pos == current.length) {
            if (valid(current)) {
                result.add(new String(current));
            }
        } else {
            current[pos] = '(';
            generateAll(current, pos + 1, result);
            current[pos] = ')';
            generateAll(current, pos + 1, result);
        }
    }

    private boolean valid(char[] current) {
        int balance = 0;
        for (char c : current) {
            if (c == '(') {
                balance++;
            } else {
                balance--;
            }
            if (balance < 0) {
                return false;
            }
        }
        return balance == 0;
    }

    public static void main(String[] args) {
        GenerateParenthesis obj = new GenerateParenthesis();
        List<String> res = obj.generateParenthesis02(3);
        System.out.println(res);
    }
}
