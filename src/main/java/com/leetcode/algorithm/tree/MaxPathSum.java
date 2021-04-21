package com.leetcode.algorithm.tree;

import com.leetcode.algorithm.tree.Node.TreeNode;

/**
 * @ ClassName MaxPathSum
 * @ author lskyline
 * @ 2021/4/21 14:43
 * @ Version: 1.0
 */
public class MaxPathSum {
    /*
     * 二叉树中的最大路径和
     */
    private int maxValue = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxPathSumHelp(root);
        return maxValue;
    }

    private int maxPathSumHelp(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left =  maxPathSumHelp(root.left);
        int right = maxPathSumHelp(root.right);
        int curValue = root.val + Math.max(0, left) + Math.max(0, right);
        maxValue = Math.max(maxValue, curValue);
        int res = root.val + Math.max(0, Math.max(left, right));
        return res;
    }

    public void inOrder(TreeNode root) {
        if (root == null) {
            return ;
        }
        inOrder(root.left);
        System.out.println(root.val);
        inOrder(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        MaxPathSum obj = new MaxPathSum();
        int res = obj.maxPathSum(root);
        System.out.println(res);
    }
}
