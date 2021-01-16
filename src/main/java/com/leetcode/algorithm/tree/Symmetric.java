package com.leetcode.algorithm.tree;

import com.leetcode.algorithm.tree.Node.TreeNode;

/**
 * @author lskyline
 * @ 2021/1/16 15:52
 *
 */
public class Symmetric {
    /*
     *  Description : leetcode101  Symmetric Tree
     *  Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
     */
    /**
     * 解题思路:
     *         递归遍历
     *         1. 如果递归遍历过程中，左子树或者右子树其中一个为空，说明不对称
     *         2. 如果递归遍历过程中，左子树或者右子树的值不相等，说明不对称
     *         3. 如果左子树、右子树遍历到叶子节点了，说明树对称
     * @param root 树的根节点
     * @return  树是否对称
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return true;
        }
        boolean symmetric = traverseTree(root.left, root.right);
        return symmetric;
    }

    private boolean traverseTree(TreeNode leftNode, TreeNode rightNode) {
        if (leftNode == null && rightNode == null) {
            return true;
        }
        if (leftNode == null || rightNode == null) {
            return false;
        }
        if (leftNode.val != rightNode.val) {
            return false;
        }
        return traverseTree(leftNode.left, rightNode.right) && traverseTree(leftNode.right, rightNode.left);
    }
}
