package com.leetcode.algorithm.Strings;

/**
 * @ ClassName ReverseWords
 * @ author lskyline
 * @ 2021/6/7 14:24
 * @ Version: 1.0
 */
public class ReverseWords {
    /*
     * 翻转单词顺序
     */
    public String reverseWords(String s) {
        char[] strs = s.toCharArray();
        int n = strs.length;
        int i = 0;
        int j = 0;
        while (j <= n) {
            if (j == n || strs[j] == ' ') {
                reverse(strs, i, j - 1);
                i = j + 1;
            }
            j++;
        }
        reverse(strs, 0, n - 1);
        return new String(strs);
    }

    private void reverse(char[] str, int i, int j) {
        while (i < j) {
            char temp = str[i];
            str[i] = str[j];
            str[j] = temp;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        String s = "I am a student.";
        ReverseWords obj = new ReverseWords();
        String res = obj.reverseWords(s);
        System.out.println(res);
    }
}
