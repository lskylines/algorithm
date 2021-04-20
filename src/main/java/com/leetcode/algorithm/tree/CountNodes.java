package com.leetcode.algorithm.tree;

import com.leetcode.algorithm.tree.Node.TreeNode;

/**
 * @ ClassName CountNodes
 * @ author lskyline
 * @ 2021/4/21 0:07
 * @ Version: 1.0
 */
public class CountNodes {
    /*
     * 完全二叉树的个数
     * 1) 递归
     * 2） 非递归
     */
    public int countNodes(TreeNode root) {
        int height = treeHeight(root);
        if (height == 0 || height == 1) {
            return height;
        }
        if (treeHeight(root.right) == height - 1) {
            return (1 << (height - 1)) + countNodes(root.right);
        } else {
            return (1 << (height -2)) + countNodes(root.left);
        }
    }

    public int countNodesUnRecv(TreeNode root) {
        int count = 0;
        int height = treeHeight(root);
        while (root != null) {
            if (treeHeight(root.right) == height - 1) {
                count += 1 << (height -1);
                root = root.right;
            } else {
                count += 1 << (height -2);
                root = root.left;
            }
            height--;
        }
        return count;
    }

    public int treeHeight(TreeNode root) {
        return root == null ? 0 : 1 + treeHeight(root.left);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(3);
        root.left.left.left = new TreeNode(4);
        root.left.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(6);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(3);
        CountNodes obj = new CountNodes();
        int res = obj.countNodes(root);
        System.out.println(res);

    }
}
