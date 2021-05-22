package com.leetcode.algorithm.tree;

import com.leetcode.algorithm.tree.Node.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;
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
     * 1） 非递归
     * 2） 递归
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
                resNode = temp;
            } else {
                preNode.left = null;
                preNode.right = temp;
            }
            preNode = temp;
        }
        return resNode;
    }

    public void flatten02(TreeNode root) {
        if (root == null) {
            return ;
        }
        List<TreeNode> list = new ArrayList<>();
        preOrder(root, list);
        TreeNode preNode = null;
        TreeNode currentNode = null;
        TreeNode target = null;
        for (int i = 1; i < list.size(); i++) {
            preNode = list.get(i -1);
            currentNode = list.get(i);
            preNode.left = null;
            preNode.right = currentNode;
            if (target == null) {
                target = preNode;
            }
        }
    }

    private void  preOrder(TreeNode root, List<TreeNode> list) {
        if (root != null) {
            list.add(root);
            preOrder(root.left, list);
            preOrder(root.right, list);
        }
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(6);
        Flatten obj = new Flatten();
        TreeNode target = obj.flatten(root);
        while (target != null) {
            System.out.println(target.val);
            target = target.right;
        }
    }
}
