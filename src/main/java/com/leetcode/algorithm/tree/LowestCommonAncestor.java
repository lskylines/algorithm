package com.leetcode.algorithm.tree;

import com.leetcode.algorithm.tree.Node.TreeNode;

/**
 * @ ClassName LowestCommonAncestor
 * @ author lskyline
 * @ 2021/5/1 17:05
 * @ Version: 1.0
 */
public class LowestCommonAncestor {
    /*
     * 二叉树搜索树的最近公共祖先
     * 1) 递归
     * 2) 循环
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if ((root.val - p.val) * (root.val - q.val) > 0) {
            root = p.val > root.val ? lowestCommonAncestor(root.right, p, q) : lowestCommonAncestor(root.left, p, q);
        }
        return root;
    }

    public TreeNode lowestCommonAncestor02(TreeNode root, TreeNode p, TreeNode q) {
        while ((root.val - p.val) * (root.val - q.val) > 0) {
            root = p.val > root.val ? root.right : root.left;
        }
        return root;
    }



    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        LowestCommonAncestor obj = new LowestCommonAncestor();
        TreeNode temp = obj.lowestCommonAncestor(root, root.left, root.right);
        System.out.println(temp.val);
    }
}
