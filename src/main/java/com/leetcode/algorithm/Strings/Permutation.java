package com.leetcode.algorithm.Strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ ClassName Permutation
 * @ author lskyline
 * @ 2021/4/20 17:38
 * @ Version: 1.0
 */
public class Permutation {
    /*
     *  字符串的排列
     */
    private List<String> res = new ArrayList<>();
    private StringBuilder curPath = new StringBuilder();
    public List<String> permutation(String s) {
        boolean[] visit = new boolean[s.length()];
        if (s == null || s.length() == 0) {
            return res;
        }
        char[] strs = s.toCharArray();
        Arrays.sort(strs);
        backtrack(strs, 0, visit);
        return res;
    }

    private void backtrack(char[] strs, int index, boolean[] visit) {
        if (index == strs.length) {
            res.add(curPath.toString());
            return ;
        }
        for (int i = 0; i < strs.length; i++) {
            if (!visit[i]) {
                if (i > 0 && strs[i] == strs[i-1] && !visit[i-1]) {
                    continue;
                }
                curPath.append(strs[i]);
                visit[i] = true;
                backtrack(strs, index + 1, visit);
                curPath.deleteCharAt(curPath.length() - 1);
                visit[i] = false;
            }
        }
    }



    public static void main(String[] args) {
        String s = "abc";
        Permutation obj = new Permutation();
        List<String> res = obj.permutation(s);
        System.out.println(res);
    }
}
