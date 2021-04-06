package com.leetcode.algorithm.Heap;

import com.leetcode.algorithm.basic.GenerateData;
import com.leetcode.algorithm.basic.GenerateSort;

/**
 * @ ClassName Heap
 * @ author lskyline
 * @ 2021/3/30 21:56
 * @ Version: 1.0
 */
public class HeapSort {

    public static void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return ;
        }
        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr, i);
        }
        int size = arr.length;
        swap(arr, 0, --size);
        while (size > 0) {
            heapify(arr, 0, size);
            swap(arr, 0, --size);
        }
    }

    public static void heapInsert(int[] arr, int index) {
        while (arr[index] > arr[(index -1) / 2]) {
            swap(arr, index, (index -1) / 2);
            index = (index - 1) / 2;
        }
    }

    public static void heapify(int[] arr, int index, int size) {
        int left = 2 * index + 1;
        while (left < size) {
            int largest = left + 1 < size && arr[left + 1] > arr[left] ? left + 1 : left;
            largest = arr[largest] > arr[index] ? largest : index;
            if (largest == index) {
                break ;
            }
            swap(arr, largest, index);
            index = largest;
            left = 2 * index + 1;
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int testNum = 50000;
        int maxValue = 100;
        int maxSize = 100;
        boolean flag = true;
        for (int i = 0; i < testNum; i++) {
            int[] arr = GenerateData.generateRandom(maxSize, maxValue);
            int[] copyArr = GenerateData.copyArray(arr);
            GenerateSort.sort(arr);
            heapSort(copyArr);
            if (!GenerateData.isEqual(arr, copyArr)) {
                flag = true;
                break ;
            }
        }
        System.out.println(flag);
    }
}
