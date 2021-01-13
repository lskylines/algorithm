package com.leetcode.algorithm.tree;

import com.leetcode.algorithm.tree.Node.TreeNode;

/**
 * @author lskyline
 * @ 2021/1/13 23:32
 *
 */
public class BalancedTree {
    /**判断是否平衡二叉树标志*/
    private Boolean flag = true;

    /*
     *  Description : leetcode110 Balanced Binary Tree
     * Given a binary tree, determine if it is height-balanced.
     */
    /**
     *  解题思路：
     *         递归，判断左右子树树的高度相差不大于1
     * @param root 树的根节点
     * @return 是否平衡二叉树
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        getMaxDepth(root);
        return flag;
    }

    public int getMaxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = getMaxDepth(root.left);
        int rightDepth = getMaxDepth(root.right);
        if (Math.abs(leftDepth - rightDepth) > 1) {
            //如果左右子树高度相差大于1，标识置为false，非平衡二叉树
            flag = false;
        }
        return Math.max(leftDepth, rightDepth) + 1;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.left.left = new TreeNode(4);
        new BalancedTree().isBalanced(treeNode);
    }
}
