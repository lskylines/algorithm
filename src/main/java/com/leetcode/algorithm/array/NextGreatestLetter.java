package com.leetcode.algorithm.array;

/**
 * @ ClassName NextGreatestLetter
 * @ author lskyline
 * @ 2021/5/10 23:15
 * @ Version: 1.0
 */
public class NextGreatestLetter {
    /*
     * 寻找比目标字母大的最小字母
     */
    public  char nextGreatestLetter(char[] letters, char target) {
        int low = 0;
        int high = letters.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (letters[mid] <= target) {
                low = mid + 1;
            } else {
                if (mid == 0 || letters[mid -1] <= target) {
                    return letters[mid];
                }
                high = mid - 1;
            }
        }
        return letters[0];
    }

    public static void main(String[] args) {

    }
}
