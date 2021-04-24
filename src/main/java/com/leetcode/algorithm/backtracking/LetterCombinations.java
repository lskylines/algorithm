package com.leetcode.algorithm.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ ClassName LetterCombinations
 * @ author lskyline
 * @ 2021/4/24 16:32
 * @ Version: 1.0
 */
public class LetterCombinations {
    /*
     * 电话号码的字母组合
     */

    private String[] letters = {" ","*","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    private List<String> res = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return res;
        }
        char[] digitStr = digits.toCharArray();
        iterStr(digitStr, new StringBuilder(), 0);
        return res;
    }

    public void iterStr(char[] digitStr, StringBuilder sb, int index) {
        if (digitStr.length == index) {
            res.add(sb.toString());
            return ;
        }
        char c  = digitStr[index];
        int pos = c - '0';
        for (int i = 0; i < letters[pos].length(); i++) {
            sb.append(letters[pos].charAt(i));
            iterStr(digitStr, sb, index + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        String digits = "23";
        LetterCombinations obj = new LetterCombinations();
        List<String> res = obj.letterCombinations(digits);
        System.out.println(res);
    }
}
