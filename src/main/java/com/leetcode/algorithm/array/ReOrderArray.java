package com.leetcode.algorithm.array;

import java.util.Arrays;

/**
 * @ ClassName ReOrderArray
 * @ author lskyline
 * @ 2021/4/10 11:27
 * @ Version: 1.0
 */
public class ReOrderArray {
    /**
     * 调整数组顺序使奇数位于偶数前面
     * 1)遍历
     * 2)双指针
     */
    public int[] reOrderArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[]{};
        }
        int oddCount = 0;
        int eventCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 != 0) {
                eventCount++;
            }
        }
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 != 0) {
                res[oddCount++] = nums[i];
            } else {
                res[eventCount++] = nums[i];
            }
        }
        return res;
    }

    public int[] reOrderArray02(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[]{};
        }

        int pre = 0;
        int last = nums.length - 1;
        while (pre < last) {
            while (pre < last && nums[pre] % 2 != 0) {
                pre++;
            }
            while (pre < last && nums[last] %2 == 0) {
                last --;
            }
            if (pre < last) {
                int temp = nums[pre];
                nums[pre] = nums[last];
                nums[last] = temp;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        ReOrderArray obj = new ReOrderArray();
        int[] arr = new int[]{1, 2, 3, 4, 5};
        int[] res = obj.reOrderArray02(arr);
        System.out.println(Arrays.toString(res));
    }
}
