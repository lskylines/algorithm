package com.leetcode.algorithm.array;

import com.leetcode.algorithm.basic.GenerateData;
import com.leetcode.algorithm.basic.GenerateSort;

import java.util.*;

/**
 * @ ClassName GetLeastNumbers
 * @ author lskyline
 * @ 2021/4/14 15:31
 * @ Version: 1.0
 */
public class GetLeastNumbers {
    /*
     * 最小的 K 个数
     * 1) 排序后，前N个数
     * 2） Partition解法
     * 3）大小为K的大顶堆
     */

    public int[] getLeastNumbers(int[] nums, int k) {
        int[] res = new int[k];
        if (nums == null || nums.length == 0 || k > nums.length) {
            return res;
        }
        quickSort(nums);
        for (int i = 0; i < k; i++) {
            res[i] = nums[i];
        }
        return res;
    }


    public int[] getLeastNumbers02(int[] nums, int k) {
        int[] res = new int[k];
        if (nums == null || nums.length == 0) {
            return res;
        }
        findKthSmallest(nums, k);
        for (int i = 0; i < k; i++) {
            res[i] = nums[i];
        }
        return res;
    }

    public int[] getLeastNumbers03(int[] nums, int k) {
        int[] res = new int[k];
        if (k >= nums.length || k < 0) {
            return res;
        }
        Queue<Integer> heap = new PriorityQueue<Integer>((o1, o2) -> o2 - o1);
        for (int i = 0; i < nums.length; i++) {
            heap.add(nums[i]);
            if (heap.size() > k) {
                heap.poll();
            }
        }
        int size = heap.size();
        int index = 0;
        while (size-- > 0) {
            res[index++] = heap.poll();
        }
        return res;
    }

    public void findKthSmallest(int[] nums, int k) {
        int low  = 0;
        int high = nums.length - 1;
        while (low < high) {
            swap(nums, low + ((int) (Math.random() * (high - low + 1))), high);
            int p = partition(nums, low, high);
            if (p == k) {
                break ;
            } else if (p > k) {
                high = p -1;
            } else {
                low = p + 1;
            }
        }
    }





    public void quickSort(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return ;
        }
        quickSort(nums, 0, nums.length -1);
    }

    public void quickSort(int[] nums, int left, int right) {
        if (left < right) {
            swap(nums, right, left + (int)(Math.random() * (right - left + 1)));
            int[] p = partitions(nums, left, right);
            quickSort(nums, left, p[0] -1);
            quickSort(nums, p[1]+ 1, right);
        }
    }

    public int[] partitions(int[] nums, int low, int high) {
        int less = low - 1;
        int more = high;
        int current = low;
        while (current < more) {
            if (nums[current] < nums[high]) {
                swap(nums, current++, ++less);
            } else if (nums[current] > nums[high]) {
                swap(nums, current, --more);
            } else {
                current++;
            }
        }
        swap(nums, more, high);
        return new int[]{less+1, more};
    }

    public int partition(int[] nums, int low, int high) {

        int less = low - 1;
        int more = high;
        int current = low;
        while (current < more) {
            if (nums[current] < nums[high]) {
                swap(nums, current++, ++less);
            } else if (nums[current] > nums[high]) {
                swap(nums, current, --more);
            } else {
                current++;
            }
        }
        swap(nums, more, high);
        return more;
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{0,0,2,3,2,1,1,2,0,4};
        System.out.println(Arrays.toString(arr));
        GetLeastNumbers obj = new GetLeastNumbers();
        int[] ret = obj.getLeastNumbers03(arr, 2);
        System.out.println(Arrays.toString(ret));
    }
}
