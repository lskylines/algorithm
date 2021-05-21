package com.leetcode.algorithm.tree;

import com.leetcode.algorithm.tree.Node.TreeNode;

import java.util.*;

/**
 * @ ClassName LowestCommonAncestorprove
 * @ author lskyline
 * @ 2021/5/1 18:28
 * @ Version: 1.0
 */
public class LowestCommonAncestorprove {
    /*
     * 二叉树的最近公共祖先
     * 1) 递归
     * 2）非递归
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode leftTree = lowestCommonAncestor(root.left, p, q);
        TreeNode rightTree = lowestCommonAncestor(root.right, p, q);
        if (leftTree == null) {
            return rightTree;
        }
        if (rightTree == null) {
            return leftTree;
        }
        return root;
    }

    public TreeNode lowestCommonAncestor02(TreeNode root, TreeNode p, TreeNode q) {
        //记录遍历到的每个节点的父节点
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        //根节点没有父节点
        parent.put(root, null);
        queue.add(root);
        while (!parent.containsKey(p) || !parent.containsKey(q)) {
            TreeNode tempNode = queue.poll();
            if (tempNode.left != null) {
                parent.put(tempNode.left, tempNode);
                queue.add((tempNode.left));
            }
            if (tempNode.right != null) {
                parent.put(tempNode.right, tempNode);
                queue.offer(tempNode.right);
            }
        }

        Set<TreeNode> ancestors = new HashSet<>();
        while (p != null) {
            ancestors.add(p);
            p = parent.get(p);
        }
        while (!ancestors.contains(q)) {
            q = parent.get(q);
        }
        return q;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        LowestCommonAncestorprove obj = new LowestCommonAncestorprove();
        TreeNode res = obj.lowestCommonAncestor02(root, root.left, root.right);
        System.out.println(res.val);

    }
}
