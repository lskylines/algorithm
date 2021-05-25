package com.leetcode.algorithm.tree;

import com.leetcode.algorithm.tree.Node.TreeNode;

import java.util.Stack;

/**
 * @ ClassName KthLargest
 * @ author lskyline
 * @ 2021/5/25 20:00
 * @ Version: 1.0
 */
public class KthLargest {
    /*
     * 二叉搜索树的第k大节点
     * 1) 非递归栈中序遍历改装实现
     * 2) Morris中序遍历改装实现
     */
    public int kthLargest(TreeNode root, int k) {
        if (root == null) {
            return 0;
        }
        int cnt = 0;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.right;
            }
            TreeNode tempNode = stack.pop();
            if (++cnt == k) {
                return tempNode.val;
            }
            root = tempNode.left;
        }
        return 0;

    }

    public int kthLargest02(TreeNode root, int k) {
        if (root == null) {
            return 0;
        }
        int cnt = 0;
        TreeNode currentNode = root;
        TreeNode mostLeftNode = null;
        TreeNode targetNode = null;
        while (currentNode != null) {
            mostLeftNode = currentNode.right;
            if (mostLeftNode != null) {
                while (mostLeftNode.left != null && mostLeftNode.left != currentNode) {
                    mostLeftNode = mostLeftNode.left;
                }
                if (mostLeftNode.left == null) {
                    mostLeftNode.left = currentNode;
                    currentNode = currentNode.right;
                    continue ;
                } else {
                    mostLeftNode.left = null;
                }
            }
            if (++cnt == k) {
                return currentNode.val;
            }
            currentNode = currentNode.left;
        }
        return 0;

    }

    public static void main(String[] args) {

    }
}
