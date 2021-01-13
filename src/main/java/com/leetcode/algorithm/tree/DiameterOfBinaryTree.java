package com.leetcode.algorithm.tree;

import com.leetcode.algorithm.tree.Node.TreeNode;

/**
 * @author lskyline
 * @ 2021/1/13 23:51
 *
 */
public class DiameterOfBinaryTree {
    /**树的直径长度*/
    private int maxLength = Integer.MIN_VALUE;
    /*
     * Description : leetcode543 Diameter of Binary Tree
     * Given a binary tree, you need to compute the length of the diameter of the tree.
     * The diameter of a binary tree is the length of the longest path between any two nodes in a tree.
     * This path may or may not pass through the root.
     */

    /**
     * 解题思路:
     *      递归，遍历树，将设置的最大长度跟左右子树高度相比较
     * @param root 树的根节点
     * @return  返回树的最大直径长度
     */
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        getMaxLength(root);
        return maxLength;
    }

    public int getMaxLength(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftLength = getMaxLength(root.left);
        int rightLength = getMaxLength(root.right);
        maxLength = Math.max(maxLength, leftLength + rightLength);
        return Math.max(leftLength, rightLength) + 1;
    }
}
