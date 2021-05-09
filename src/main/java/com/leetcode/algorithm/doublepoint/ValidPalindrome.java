package com.leetcode.algorithm.doublepoint;

/**
 * @ ClassName ValidPalindrome
 * @ author lskyline
 * @ 2021/5/9 20:26
 * @ Version: 1.0
 */
public class ValidPalindrome {
    /*
     *验证回文字符串 Ⅱ
     */
    public boolean validPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        for (int i =0, j = s.length() -1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return isPalindrome(s, i, j - 1) || isPalindrome(s, i + 1, j);
            }
        }
        return true;
    }

    private boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            } else {
                i++;
                j--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "aba";
        ValidPalindrome obj = new ValidPalindrome();
        boolean flag = obj.validPalindrome(s);
        System.out.println(flag);
    }
}
