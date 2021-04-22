package com.leetcode.algorithm.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ ClassName BucketSort
 * @ author lskyline
 * @ 2021/4/22 15:26
 * @ Version: 1.0
 */
public class BucketSort {
    /*
     * 桶排序
     */
    public static void bucketSort(int[] arr, int bucketSize) {

        int max = arr[0];
        int min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(arr[i], max);
            min = Math.min(arr[i], min);
        }
        int bucketCount = (max - min) / bucketSize + 1;
        List<List<Integer>> buckets = new ArrayList<>();
        for (int i = 0; i < bucketCount; i++) {
            buckets.add(new ArrayList<>());
        }
        for (int i = 0; i < arr.length; i++) {
            buckets.get((arr[i] - min) / bucketSize).add(arr[i]);
        }

        int currentIndex  = 0;
        for (int i = 0; i < buckets.size(); i++) {
            Integer[] bucketArray = new Integer[buckets.get(i).size()];
            bucketArray = buckets.get(i).toArray(bucketArray);
            Arrays.sort(bucketArray);
            for (int j = 0; j < bucketArray.length; j++) {
                arr[currentIndex++] = bucketArray[j];
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 5, 6, 7, 3, 2, 3, 4, 5, 6};
        bucketSort(arr, 3);
        System.out.println(Arrays.toString(arr));
    }
}
