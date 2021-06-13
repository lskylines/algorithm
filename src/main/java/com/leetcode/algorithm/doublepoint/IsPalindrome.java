package com.leetcode.algorithm.doublepoint;

/**
 * @ ClassName IsPalindrome
 * @ author lskyline
 * @ 2021/6/13 18:25
 * @ Version: 1.0
 */
public class IsPalindrome {
    /*
     * 验证回文串
     * 1)双指针
     */
    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            //判断是否字符或者数字
            if (Character.isLetterOrDigit(c)) {
                sb.append(c);
            }
        }
        char[] strs = sb.toString().toCharArray();
        int left = 0;
        int right = strs.length - 1;
        while (left <= right) {
            //转化为大小写
            if (Character.toLowerCase(strs[left]) != Character.toLowerCase(strs[right])) {
                return false;
            }
            left++;
            right--;
        }
        //如果左右指针相撞，说明都相等
        return true;
    }
}
