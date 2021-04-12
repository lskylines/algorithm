package com.leetcode.algorithm.tree;

import com.leetcode.algorithm.tree.Node.TreeNode;

import java.util.Stack;

/**
 * @ ClassName VerifySquenceOfBST
 * @ author lskyline
 * @ 2021/4/12 15:05
 * @ Version: 1.0
 */
public class VerifySquenceOfBST {
    /*
     * 二叉搜索树的后序遍历序列
     */
    public boolean verifySquenceOfBST(int[] seq) {
        if (seq == null || seq.length == 0) {
            return false;
        }
        return verify(seq, 0, seq.length - 1);
    }

    public boolean verify(int[] sequence, int first, int last) {
        if (last - first <= 1) {
            return true;
        }
        int rootValue = sequence[last];
        int currentIndex  = first;
        while (currentIndex < last && sequence[currentIndex] <= rootValue) {
            currentIndex++;
        }
        for (int i = currentIndex; i < last; i++) {
            if (sequence[i] < rootValue) {
                return false;
            }
        }
        return verify(sequence, first, currentIndex-1) && verify(sequence, currentIndex, last - 1);
    }
}
