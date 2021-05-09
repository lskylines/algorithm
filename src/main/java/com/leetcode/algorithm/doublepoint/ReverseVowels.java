package com.leetcode.algorithm.doublepoint;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @ ClassName ReverseVowels
 * @ author lskyline
 * @ 2021/5/9 20:03
 * @ Version: 1.0
 */
public class ReverseVowels {
    /*
     * 反转字符串中的元音字母
     * 1)双指针
     */
    private Set<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
    public String reverseVowels(String s) {
        if (s == null || s.length() == 0) {
            return null;
        }
        char[] strs = s.toCharArray();
        int p1 = 0;
        int p2 = strs.length - 1;
        while (p1 < p2) {
            char c1 = strs[p1];
            char c2 = strs[p2];
            if (set.contains(c1) && set.contains(c2)) {
                //交换两个元音字母
                char temp = c1;
                strs[p1] = c2;
                strs[p2] = temp;
                p1++;
                p2--;
            } else if (!set.contains(c1) && set.contains(c2)) {
                p1++;
            } else if (set.contains(c1) && !set.contains(c2)) {
                p2--;
            } else {
                p1++;
                p2--;
            }
        }
        return new String(strs);
    }

    public static void main(String[] args) {
        String s = "hello";
        ReverseVowels obj = new ReverseVowels();
        String res = obj.reverseVowels(s);
        System.out.println(res);
    }
}
