package com.leetcode.algorithm.tree;

import com.leetcode.algorithm.tree.Node.TreeNode;

/**
 * @ author lskyline
 * @ className MinDepth
 * @ 2021/1/16 16:19
 * @ Version: 1.0
 */
public class MinDepth {

    /*
     * Description : leetcode111  Minimum Depth of Binary Tree
     * Given a binary tree, find its minimum depth.
     * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
     */
    /**
     * 解题思路:
     *      1. 如果树是左右子树都有值， 递归计算树的深度，取左右子树中最小深度值
     *      2. 如果树是一条链表， 那么递归计算深度后，取最大值
     * @param root 树的根节点
     * @return 树的最小深度
     */
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = minDepth(root.left);
        int rightDepth = minDepth(root.right);
        if (leftDepth == 0 || rightDepth == 0) {
            return Math.max(leftDepth, rightDepth) + 1;
        }
        return Math.min(leftDepth, rightDepth) + 1;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.right = new TreeNode(2);
        node.right.right = new TreeNode(3);
        node.right.right.right = new TreeNode(4);
        MinDepth obj = new MinDepth();
        int minDepth = obj.minDepth(node);
        System.out.println(minDepth);
    }

}
