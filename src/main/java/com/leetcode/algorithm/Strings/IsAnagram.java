package com.leetcode.algorithm.Strings;

import java.util.HashMap;
import java.util.Map;

/**
 * @ ClassName IsAnagram
 * @ author lskyline
 * @ 2021/1/18 22:43
 * @ Version: 1.0
 */
public class IsAnagram {

    /*
     *   Description : leetcode242  Valid Anagram
     *   Given two strings s and t , write a function to determine if t is an anagram of s.
     */


    /**
     * 解题思路:
     *          1. 遍历字符串S时，将字符保存在数组中，进行++操作，统计每个字符的数量
     *          2. 遍历字符串T时，将字符数量--
     *          3. 遍历数组，如果数组中字符个数都为0，说明相同
     * @param s 字符串S
     * @param t 字符串T
     * @return 返回两个字符串包含的字符是否完全相同
     */
    public boolean isAnagram(String s, String t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        int [] alphabet = new int[26];
        for (int i = 0; i < s.length(); i++) {
            alphabet[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            alphabet[t.charAt(i) - 'a']--;
        }
        for (int i = 0; i < alphabet.length; i++) {
            if (alphabet[i] != 0) {
                return false;
            }
        }
        return true;
    }

    /**使用Map存储的方式实现*/
    public boolean isAnagram02(String s, String t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap<>();
       /* for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) - 1);
        }*/
        s.codePoints().forEach(code -> map.put(code, map.getOrDefault(code, 0) + 1));
        t.codePoints().forEach(code -> map.put(code, map.getOrDefault(code, 0) -1));
        for (int count : map.values()) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }
}
