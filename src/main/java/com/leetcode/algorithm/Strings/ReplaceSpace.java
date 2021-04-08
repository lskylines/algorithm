package com.leetcode.algorithm.Strings;

/**
 * @ ClassName ReplaceSpace
 * @ author lskyline
 * @ 2021/4/9 6:28
 * @ Version: 1.0
 */
public class ReplaceSpace {
    /**替换空格*/
    public String replaceSpace(String str) {
        if (str == null || str.length() < 1) {
            return str;
        }
        int p1 = str.length() - 1;
        int p2 = 0;
        for (int i = 0; i < p1; i++) {
            if (str.charAt(i) == ' ') {
                p2 += 2;
            } else {
                p2++;
            }
        }
        StringBuilder sb = new StringBuilder(p2);
        for (int i = 0; i <= p1 ; i++) {
            if (str.charAt(i) == ' ') {
                sb.append("%20");
            } else {
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        ReplaceSpace obj = new ReplaceSpace();
        String str = "We are happy";
        String replaceStr = obj.replaceSpace(str);
        System.out.println(replaceStr);
    }
}
