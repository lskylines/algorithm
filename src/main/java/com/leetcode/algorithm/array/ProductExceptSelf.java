package com.leetcode.algorithm.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ ClassName ProductExceptSelf
 * @ author lskyline
 * @ 2021/4/27 9:41
 * @ Version: 1.0
 */
public class ProductExceptSelf {
    /*
     *  除自身以外数组的乘积
     *  左右乘积列表
     */
    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[]{0};
        }
        int length = nums.length;
        int[] L = new int[length];
        int[] R = new int[length];
        int[] ans = new int[length];
        L[0] = 1;
        for (int i = 1; i < length; i++) {
            L[i] = L[i - 1] * nums[i - 1];
        }
        R[length - 1] = 1;
        for (int i = length - 2; i >= 0 ; i--) {
            R[i] = R[i + 1] * nums[i + 1];
        }

        for (int i = 0; i < nums.length; i++) {
            ans[i] = L[i] * R[i];
        }
        return ans;
    }

    public int[] productExceptSelf02(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[]{0};
        }
        int[] res = new int[nums.length];
        res[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            res[i] =  nums[i - 1] * res[i - 1];
        }
        int R = 1;
        for (int i = nums.length - 1; i >= 0 ; i--) {
            res[i] = res[i] * R;
            R *= nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4};
        ProductExceptSelf obj = new ProductExceptSelf();
        int[] res = obj.productExceptSelf(nums);
        System.out.println(Arrays.toString(res));
    }
}
