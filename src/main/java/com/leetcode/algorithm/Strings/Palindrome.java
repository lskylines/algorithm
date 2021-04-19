package com.leetcode.algorithm.Strings;

/**
 * @ ClassName Palindrome
 * @ author lskyline
 * @ 2021/4/15 11:43
 * @ Version: 1.0
 */
public class Palindrome {
    public int palindrome(String str) {
        if (str == null || str.length() < 1) {
            return 0;
        }
        char[] ss = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ss.length; i++) {
            if (i == ss.length - 1) {
                sb.append("#" + ss[i] + "#");
            } else {
                sb.append("#" + ss[i]);
            }
        }
        char[] newS = sb.toString().toCharArray();
        int pre = 0;
        int last = 0;
        int[] sum = new int[newS.length];
        for (int i = 0; i < sum.length; i++) {
            sum[i] = 1;
        }
        int max  = 1;
        for (int i = 0; i < newS.length; i++) {
            pre = i - 1;
            last = i + 1;
            while (pre >= 0 && last < newS.length && newS[pre] == newS[last]) {
                sum[i] += 2;
                pre--;
                last++;
            }
            max = Math.max(sum[i], max);
        }
        return max / 2;
    }

    public static void main(String[] args) {
        String str = "811131118";
        Palindrome obj = new Palindrome();
        int max = obj.palindrome(str);
        System.out.println(max);
    }
}
