package com.leetcode.algorithm.bit;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @ ClassName SortByBits
 * @ author lskyline
 * @ 2021/4/22 22:40
 * @ Version: 1.0
 */
public class SortByBits {
    /**
     * 根据数字二进制下 1 的数目排序
     */
    public int[] sortByBits(int[] arr) {
        int length = arr.length;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0 ; i < length; i++) {
            int count = count(arr[i]);
            map.put(arr[i], count);
        }
        int[] res = new int[length];
        int index = 0;
        Map<Integer, Integer> collect = map.entrySet().stream().sorted(Map.Entry.<Integer, Integer>comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        for (Map.Entry<Integer, Integer> entry : collect.entrySet()) {
            System.out.println(entry.getKey() + ":" +  entry.getValue());
            res[index++] = entry.getKey();
        }
        return res;
    }

    private int count(int n) {
        int count = 0;
        while (n != 0) {
            n = n & (n-1);
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{10000, 10000};
        SortByBits obj = new SortByBits();
        int[] res = obj.sortByBits(arr);
        System.out.println(Arrays.toString(res));
    }
}
