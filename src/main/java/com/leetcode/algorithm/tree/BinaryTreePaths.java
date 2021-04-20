package com.leetcode.algorithm.tree;

import com.leetcode.algorithm.tree.Node.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ ClassName BinaryTreePaths
 * @ author lskyline
 * @ 2021/4/21 0:38
 * @ Version: 1.0
 */
public class BinaryTreePaths {
    /**
     * 二叉树的所有路径
     */
    private List<String> ret = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return ret;
        }
        backTrace(root, "");
        return ret;
    }

    private void backTrace(TreeNode root, String s) {
        if (root == null) {
            return ;
        }
        if (root.left == null && root.right == null) {
            ret.add(s + root.val);
            return ;
        }
        if (root.left != null) {
            backTrace(root.left, s + root.val + "->");
        }
        if (root.right != null) {
            backTrace(root.right, s + root.val + "->");
        }

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        BinaryTreePaths obj = new BinaryTreePaths();
        List<String> ret = obj.binaryTreePaths(root);
        for (String str : ret) {
            System.out.println(str);
        }
    }
}
