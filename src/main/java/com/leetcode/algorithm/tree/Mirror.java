package com.leetcode.algorithm.tree;

import com.leetcode.algorithm.tree.Node.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @ ClassName Mirror
 * @ author lskyline
 * @ 2021/4/12 11:01
 * @ Version: 1.0
 */
public class Mirror {
    /*
     * 二叉树的镜像
     * 1) 递归
     * 2） 非递归
     */
    public TreeNode mirror(TreeNode root) {
        if (root == null) {
            return root;
        }
        swap(root);
        mirror(root.left);
        mirror(root.right);
        return root;
    }

    public void swap(TreeNode node) {
        TreeNode tempNode = node.left;
        node.left = node.right;
        node.right = tempNode;
    }

    public TreeNode mirror02(TreeNode root) {
        if (root == null) {
            return root;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode tempNode = stack.pop();
            swap(tempNode);
            if (tempNode.right != null) {
                stack.push(tempNode.right);
            }
            if (tempNode.left != null) {
                stack.push(tempNode.left);
            }
        }
        return root;
    }

    public List<Integer> InorderUnRecv(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> arr = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode tempNode = stack.pop();
            arr.add(tempNode.val);
            root = tempNode.right;
        }
        return arr;
    }



    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        Mirror obj = new Mirror();
        obj.mirror02(root);
        List<Integer> orderNum = obj.InorderUnRecv(root);
        System.out.println(orderNum);

    }
}
