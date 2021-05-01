package com.leetcode.algorithm.tree;

import com.leetcode.algorithm.tree.Node.TreeNode;

import java.util.Stack;

/**
 * @ ClassName IsValidBST
 * @ author lskyline
 * @ 2021/5/1 22:09
 * @ Version: 1.0
 */
public class IsValidBST {
    /*
     * 验证二叉搜索树
     * 1) 中序遍历
     */
    private TreeNode preNode;
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                System.out.println(root.val);
                if (preNode != null && preNode.val >= root.val) {
                    return false;
                }
                preNode = root;
                root = root.right;
            }
        }
        return true;
    }

    public boolean isValidBST02(TreeNode root) {
        if (root == null) {
            return true;
        }
        TreeNode currentNode = root;
        TreeNode mostRightNode = null;
        while (currentNode != null) {
            mostRightNode = currentNode.left;
            if (mostRightNode != null) {
                while (mostRightNode.right != null && mostRightNode.right != currentNode) {
                    mostRightNode = mostRightNode.right;
                }
                if (mostRightNode.right == null) {
                    mostRightNode.right = currentNode;
                    currentNode = currentNode.left;
                    continue ;
                } else {
                    mostRightNode = null;
                }
            }
            if (preNode != null && preNode.val >= currentNode.val) {
                return false;
            }
            preNode = currentNode;
            currentNode = currentNode.right;
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(6);
        IsValidBST obj = new IsValidBST();
        boolean flag = obj.isValidBST02(root);
        System.out.println(flag);
    }
}
