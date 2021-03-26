package com.leetcode.algorithm.tree;

import com.leetcode.algorithm.tree.Node.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ ClassName FindBottomLeftValue
 * @ author lskyline
 * @ 2021/1/17 11:30
 * @ Version: 1.0
 */
public class FindBottomLeftValue {
    /*
     *  Description : leetcode513 Find Bottom Left Tree Value
     *  Given the root of a binary tree, return the leftmost value in the last row of the tree.
     */
    /**
     * 解题思路:
     *      1. 使用队列，采用BFS， 从右至左往队列中添加元素
     * @param root 根节点
     * @return 返回左下角的节点
     */
    public int findBottomLeftValue(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            root = queue.remove();
            if (root.right != null) {
                queue.add(root.right);
            }
            if (root.left != null) {
                queue.add(root.left);
            }
        }
        return root.val;
    }

    public int findBottomLeftValue02(TreeNode root) {
        if (root == null) {
            return 0;
        }
        TreeNode res = null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            res = queue.peek();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode tempNode = queue.poll();
                if (tempNode.left != null) {
                    queue.add(tempNode.left);
                }
                if (tempNode.right != null) {
                    queue.add(tempNode.right);
                }
            }
        }
        return res.val;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.right.left.left = new TreeNode(7);
        FindBottomLeftValue obj = new FindBottomLeftValue();
        int num = obj.findBottomLeftValue(root);
        System.out.println(num);
    }
}
