package com.leetcode.algorithm.Strings;

/**
 * @ ClassName FirstNotRepeatingChar
 * @ author lskyline
 * @ 2021/4/19 9:55
 * @ Version: 1.0
 */
public class FirstNotRepeatingChar {
    /*
     * 第一个只出现一次的字符位置
     */
    public int firstNotRepeatingChar(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        int[] cnts = new int[256];
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            cnts[c]++;
        }
        for (int i = 0; i < str.length(); i++) {
            if (cnts[str.charAt(i)] == 1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        FirstNotRepeatingChar obj = new FirstNotRepeatingChar();
        String s = "abaccdeff";
        int res = obj.firstNotRepeatingChar(s);
        System.out.println(res);
    }
}
