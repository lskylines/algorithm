package com.leetcode.algorithm.Strings;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * @ ClassName LengthOfLongestSubstring
 * @ author lskyline
 * @ 2021/4/23 23:19
 * @ Version: 1.0
 */
public class LengthOfLongestSubstring {
    /*
     * 最长不含重复字符的子字符串
     */
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 0, j = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                j = Math.max(j, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - j + 1);
        }
        return max;
    }

    public int lengthOfLongestSubstring02(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int max = 0;
        Queue<Character> queue = new LinkedList<>();
        for (char c : s.toCharArray()) {
            while (queue.contains(c)) {
                queue.poll();
            }
            queue.add(c);
            max = Math.max(max, queue.size());
        }
        return max;
    }

    public static void main(String[] args) {
        LengthOfLongestSubstring obj = new LengthOfLongestSubstring();
        int res = obj.lengthOfLongestSubstring("abba");
        System.out.println(res);
    }
}
