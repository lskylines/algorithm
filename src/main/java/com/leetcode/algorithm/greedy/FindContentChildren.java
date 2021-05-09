package com.leetcode.algorithm.greedy;

import java.util.Arrays;

/**
 * @ ClassName FindContentChildren
 * @ author lskyline
 * @ 2021/5/9 22:40
 * @ Version: 1.0
 */
public class FindContentChildren {
    /*
     * 分发饼干
     */
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int gi = 0;
        int si = 0;
        while (gi < g.length && si < s.length) {
            if (g[gi] <= s[si]) {
                gi++;
            }
            si++;
        }
        return gi;
    }
}
