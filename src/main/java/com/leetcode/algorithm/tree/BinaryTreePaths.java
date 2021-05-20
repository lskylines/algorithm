package com.leetcode.algorithm.tree;

import com.leetcode.algorithm.tree.Node.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @ ClassName BinaryTreePaths
 * @ author lskyline
 * @ 2021/4/21 0:38
 * @ Version: 1.0
 */
public class BinaryTreePaths {
    /**
     * 二叉树的所有路径
     * 1) 深度优先遍历
     * 2） 广度优先遍历
     */
    private List<String> ret = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return ret;
        }
        backTrace(root, "");
        return ret;
    }

    public List<String> binaryTreePaths02(TreeNode root) {
        List<String> paths = new ArrayList<>();
        if (root == null) {
            return paths;
        }
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<String> pathQueue = new LinkedList<>();
        nodeQueue.offer(root);
        pathQueue.offer(Integer.toString(root.val));
        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.poll();
            String path = pathQueue.poll();
            if (node.left == null && node.right == null) {
                paths.add(path);
            } else {
                if (node.left != null) {
                    nodeQueue.offer(node.left);
                    pathQueue.offer(new StringBuffer(path).append("->").append(node.left.val).toString());
                }
                if (node.right != null) {
                    nodeQueue.offer(node.right);
                    pathQueue.offer(new StringBuffer(path).append("->").append(node.right.val).toString());
                }
            }
        }
        return paths;
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
