package com.leetcode.algorithm.Heap;

import sun.font.FontRunIterator;

import java.util.*;

/**
 * @ ClassName TopKFrequent
 * @ author lskyline
 * @ 2021/4/29 10:11
 * @ Version: 1.0
 */
public class TopKFrequent {
    /*
     * 前 K 个高频元素
     * 1) 最小堆
     * 2） 桶排序
     */
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            minHeap.offer(new int[]{entry.getKey(), entry.getValue()});
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = Objects.requireNonNull(minHeap.poll())[0];
        }
        return res;
    }

    public List<Integer> topKFrequent02(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        //桶排序
        List<Integer>[] list = new List[nums.length + 1];
        for (int key : map.keySet()) {
            int i = map.get(key);
            if (list[i] == null) {
                list[i] = new ArrayList<>();
            }
            list[i].add(key);
        }
        for (int i = list.length -1; i >= 0 && res.size() < k; i--) {
            if (list[i] == null) {
                continue;
            }
            res.addAll(list[i]);
        }
        return res;
    }



    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1, 2, 2, 3};
        TopKFrequent obj = new TopKFrequent();
        List<Integer>  res = obj.topKFrequent02(nums,2 );
        System.out.println(res);
    }

}
