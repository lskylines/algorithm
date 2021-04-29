package com.leetcode.algorithm.num;

import java.util.ArrayList;
import java.util.List;

/**
 * @ ClassName FindDisappearedNumbers
 * @ author lskyline
 * @ 2021/4/29 16:09
 * @ Version: 1.0
 */
public class FindDisappearedNumbers {
    /*
     * 找到所有数组中消失的数字(要求空间复杂度O（1））
     * 1) 根据数据规律，进行交换
     * 2）标记法
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i + 1) {
                swap(nums, nums[i] -1, i);
                if (nums[i] == nums[nums[i]-1]) {
                    break ;
                }
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != i + 1) {
                result.add(i + 1);
            }
        }
        return result;
    }

    public List<Integer> findDisappearedNumbers02(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) -1;
            if (nums[index] > 0) {
                nums[index] *= -1;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                res.add(i + 1);
            }
        }
        return res;
    }

    private void print(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + "\t");
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4, 3, 2, 7, 8, 2, 3, 1};
        FindDisappearedNumbers obj = new FindDisappearedNumbers();
        List<Integer> res = obj.findDisappearedNumbers02(arr);
        System.out.println(res);
    }
}
