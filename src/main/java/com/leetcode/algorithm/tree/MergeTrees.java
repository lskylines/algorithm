package com.leetcode.algorithm.tree;

import com.leetcode.algorithm.tree.Node.TreeNode;

/**
 * @author lskyline
 * @ 2021/1/16 12:50
 *
 */
public class MergeTrees {
    /*
     * Description : leetcode617  Merge Two Binary Trees
     * Given two binary trees and imagine that when you put one of them to cover the other,
     * some nodes of the two trees are overlapped while the others are not.
     */


    /**
     * 解题思路: 创建新的节点，节点值为tree1与tree2之和，递归左子树、右子树
     * @param t1 Tree1 根节点
     * @param t2 Tree2 根节点
     * @return  返回新的树
     */
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return null;
        }
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }
        TreeNode newNode = buildNewTree(t1, t2);
        newNode.left = mergeTrees(t1.left, t2.left);
        newNode.right = mergeTrees(t1.right, t2.right);
        return newNode;
    }

    public TreeNode buildNewTree (TreeNode t1, TreeNode t2){
        TreeNode newTreeNode = new TreeNode(t1.val + t2.val);
        return newTreeNode;
    }
}
