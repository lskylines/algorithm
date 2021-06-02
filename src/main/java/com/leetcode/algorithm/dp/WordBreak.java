package com.leetcode.algorithm.dp;

import java.util.List;

/**
 * @ ClassName WordBreak
 * @ author lskyline
 * @ 2021/6/2 23:23
 * @ Version: 1.0
 */
public class WordBreak {
    /*
     * 单词拆分
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || wordDict == null) {
            return false;
        }
        int len = s.length();
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                String word = s.substring(j, i);
                if (dp[j] && wordDict.contains(word)) {
                    dp[i] = true;
                }
            }
        }
        return dp[len];
    }
}

