package com.leetcode.algorithm.tree;

import com.leetcode.algorithm.tree.Node.TreeNode;

import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * @ ClassName PrintFromTopToBottom
 * @ author lskyline
 * @ 2021/4/12 14:24
 * @ Version: 1.0
 */
public class PrintFromTopToBottom {
    /*
     * 1)从上往下打印二叉树的每个节点
     * 2)从上往下多行打印二叉树
     * 3)之字形从上到下打印二叉树的每个节点
     */
    public List<Integer> printFromTopToBottom(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                TreeNode tempNode = queue.poll();
                if (tempNode == null) {
                    continue;
                }
                res.add(tempNode.val);
                if (tempNode.left != null) {
                    queue.add(tempNode.left);
                }
                if (tempNode.right != null) {
                    queue.add(tempNode.right);
                }
            }
        }
        return res;
    }

    public List<List<Integer>> printFromTopToBottom02(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size  = queue.size();
            List<Integer> help = new ArrayList<>();
            while (size-- > 0) {
                TreeNode tempNode = queue.poll();
                if (tempNode == null) {
                    continue;
                }
                help.add(tempNode.val);
                if (tempNode.left != null) {
                    queue.add(tempNode.left);
                }
                if (tempNode.right != null) {
                    queue.add(tempNode.right);
                }
            }
            if (help.size() > 0) {
                res.add(help);
            }
        }
        return res;
    }

    public List<List<Integer>> printFromTopToBottom03(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean reverse = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> help = new ArrayList<>();
            while (size -- > 0) {
                TreeNode tempNode = queue.poll();
                if (tempNode == null) {
                    continue;
                }
                help.add(tempNode.val);
                if (tempNode.left != null) {
                    queue.add(tempNode.left);
                }
                if (tempNode.right != null) {
                    queue.add(tempNode.right);
                }
            }
            reverse = !reverse;
            if (reverse) {
                Collections.reverse(help);
            }
            res.add(help);
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        PrintFromTopToBottom obj = new PrintFromTopToBottom();
        List<List<Integer>> res = obj.printFromTopToBottom03(root);
        for (List<Integer> data : res) {
            System.out.println(data);
        }
    }
}
