package com.leetcode.algorithm.tree;

import com.leetcode.algorithm.tree.Node.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @ ClassName ConvertBST
 * @ author lskyline
 * @ 2021/1/17 17:13
 * @ Version: 1.0
 */
public class ConvertBST {
    /*
     * Description : leetcode538  Convert BST to Greater Tree
     * Given the root of a Binary Search Tree (BST)
     * convert it to a Greater Tree such that every key of the original BST is changed to the original key plus sum of all keys greater than the original key in BST.
     */

    /**统计累加值*/
    private int sum = 0;

    /**
     *
     * @param root 根节点
     * @return  返回重组后的树
     */
    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        traverseTree(root);
        return root;
    }

    private void traverseTree(TreeNode root) {
        if (root == null) {
            return ;
        }
        traverseTree(root.right);
        sum += root.val;
        root.val = sum;
        traverseTree(root.left);
    }

    public TreeNode convertBST02(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode node =root;
        int sum = 0;
        Deque<TreeNode> stack = new LinkedList<>();
        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                stack.push(node);
                node = node.right;
            } else {
                node = stack.pop();
                sum += node.val;
                node.val = sum;
                node = node.left;
            }
        }
        return root;
    }
}
