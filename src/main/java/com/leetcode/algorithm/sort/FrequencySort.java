package com.leetcode.algorithm.sort;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @ ClassName FrequencySort
 * @ author lskyline
 * @ 2021/5/9 21:57
 * @ Version: 1.0
 */
public class FrequencySort {
    /**
     * 字符出现频率排序
     */
    public String frequencySort(String s) {
        if (s == null || s.length() == 0){
            return null;
        }

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }


        Map<Character, Integer> collect = map.entrySet().stream().sorted(Map.Entry.<Character, Integer>comparingByValue().reversed())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : collect.entrySet()) {
            int count = entry.getValue();
            for (int i = 0; i < count; i++) {
                sb.append(entry.getKey());
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "tree";
        FrequencySort obj = new FrequencySort();
        obj.frequencySort(s);
    }
}
