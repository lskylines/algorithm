package com.leetcode.algorithm.designed;

/**
 * @ ClassName Singleton
 * @ author lskyline
 * @ 2021/5/19 9:26
 * @ Version: 1.0
 */
public class Singleton {
    private volatile static Singleton instance;

    private Singleton() {

    }

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
