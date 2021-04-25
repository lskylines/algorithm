package com.leetcode.algorithm.array;

import java.util.Arrays;

/**
 * @ ClassName Merge
 * @ author lskyline
 * @ 2021/4/25 22:07
 * @ Version: 1.0
 */
public class Merge {
    /*
     * 合并区间 todo + 1
     */
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (v1, v2) -> v1[0] - v2[0]);
        int[][] res = new int[intervals.length][2];

        int row = intervals.length;

        int[][] resultIntervals = new int[row][2];
        //指向上一次计算的结果区间
        int resultIntervalsPosition = 0;
        resultIntervals[resultIntervalsPosition] = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            int[] currentResultInterval = resultIntervals[resultIntervalsPosition];
            if (intervals[i][0] > currentResultInterval[1]) {
                resultIntervalsPosition++;
                resultIntervals[resultIntervalsPosition] = intervals[i];
            } else {
                currentResultInterval[1] = Math.max(intervals[i][1], currentResultInterval[1]);
                resultIntervals[resultIntervalsPosition] = currentResultInterval;
            }
        }
        for (int i = 0; i < resultIntervals.length; i++) {

            System.out.println(Arrays.toString(resultIntervals[i]));
        }
        return Arrays.copyOf(resultIntervals, resultIntervalsPosition + 1, resultIntervals.getClass());
    }

    public static void main(String[] args) {
        int[][] intervals = new int[][]{{1,3},{2,6},{8,10},{15,18}};
        Merge obj = new Merge();
        int[][] res = obj.merge(intervals);
        for (int i = 0; i < res.length; i++) {
            System.out.println(Arrays.toString(res[i]));
        }
    }
}
