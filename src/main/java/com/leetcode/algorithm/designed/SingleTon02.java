package com.leetcode.algorithm.designed;

/**
 * @ ClassName SingleTon02
 * @ author lskyline
 * @ 2021/6/11 14:21
 * @ Version: 1.0
 */
public class SingleTon02 {
    public static class SingleTonHolder {
        private static final SingleTon02 INSTANCE = new SingleTon02();
    }

    private SingleTon02() {}

    public static final SingleTon02 getInstance() {
        return SingleTonHolder.INSTANCE;
    }
}
