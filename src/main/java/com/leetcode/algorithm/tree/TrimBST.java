package com.leetcode.algorithm.tree;

import com.leetcode.algorithm.tree.Node.TreeNode;

/**
 * @ ClassName TrimBST
 * @ author lskyline
 * @ 2021/1/17 16:40
 * @ Version: 1.0
 */
public class TrimBST {
    /*
     * Description : leetcode669  Trim a Binary Search Tree
     * Given the root of a binary search tree and the lowest and highest boundaries as low and high,
     *  trim the tree so that all its elements lies in [low, high].
     * Trimming the tree should not change the relative structure of the elements that will remain in the tree (i.e., any node's descendant should remain a descendant).
     *  It can be proven that there is a unique answer.
     */
    /**
     * 解题思路: 采用递归，根据在二叉树左子树小于根节点，右子树大于根节点的特性来实现
     * @param root 根节点
     * @param low  最小
     * @param high 最大
     * @return 返回符合[L,R]区间的树
     */
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) {
            return null;
        }
        if (root.val < low) {
            return trimBST(root.right, low, high);
        }
        if (root.val > high) {
            return trimBST(root.left, low, high);
        }
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        return root;
    }
}
