package com.leetcode.algorithm.Strings;

import java.util.HashSet;
import java.util.Set;

/**
 * @ ClassName LongestPalindrome
 * @ author lskyline
 * @ 2021/1/19 22:31
 * @ Version: 1.0
 */
public class LongestPalindrome {

    /*
     * Description : leetcode409  Longest Palindrome
     * Given a string s which consists of lowercase or uppercase letters, return the length of the longest palindrome that can be built with those letters
     */

    /**
     * 解题思路:
     *          将字符串存储在数组中，index为字符串数值，value为数量，进行统计
     * @param s 字符串
     * @return 可以组成回文字符串的最大长度
     */
    public int longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int[] strs = new int[256];
        for (char c : s.toCharArray()) {
            strs[c]++;
        }
        int res = 0;
        for (int cnt : strs) {
            res += (cnt / 2 ) * 2;
        }
        if (res < s.length()) {
            res ++;
        }
        return res;
    }

    public int longestPalindrome02(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int res = 0;
        Set<Character> hs = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (hs.contains(c)) {
                hs.remove(c);
                res ++;
            } else {
                hs.add(c);
            }
        }
        if (!hs.isEmpty()) {
            return res * 2 + 1;
        }
        return res * 2;

    }

}
