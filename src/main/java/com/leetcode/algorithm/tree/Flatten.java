package com.leetcode.algorithm.tree;

import com.leetcode.algorithm.tree.Node.TreeNode;

import java.util.Stack;

/**
 * @ ClassName Flatten
 * @ author lskyline
 * @ 2021/4/26 11:08
 * @ Version: 1.0
 */
public class Flatten {
    /*
     * 二叉树展开为链表
     */
    private TreeNode preNode;
    private TreeNode targetNode;
    public TreeNode flatten(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode preNode = null;
        TreeNode resNode = null;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            if (temp.right != null) {
                stack.push(temp.right);
            }
            if (temp.left != null) {
                stack.push(temp.left);
            }
            if (preNode == null) {
                preNode = temp;
                resNode = temp;
            } else {
                preNode.left = null;
                preNode.right = temp;
                preNode = temp;
            }
        }
        return resNode;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(6);
        Flatten obj = new Flatten();
        TreeNode res = obj.flatten(root);
        while (res != null) {
            res = res.right;
        }
    }
}
