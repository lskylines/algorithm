package com.leetcode.algorithm.tree;

import com.leetcode.algorithm.tree.Node.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author lskyline
 * @ 2021/1/15 0:16
 *
 */
public class InvertTree {
    /*
     * Description : leetcode226  Invert Binary Tree
     * Invert a binary tree.
     */


    /**
     * 解题思路:
     *          递归，将树进行左右子树反转
     * @param root 树的根节点
     * @return  返回反转后的树
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        //反转根节点左右子树
        reverseTree(root);
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    public void reverseTree(TreeNode root) {
        if (root == null) {
            return ;
        }
        //使用临时节点保存根节点左子树
        TreeNode tempNode = root.left;
        //将根节点右子树的赋给左子树
        root.left = root.right;
        //将临时节点保存的左子树赋给右子树
        root.right = tempNode;
    }


    /**
     *  解题思路:
     *         采用栈，将根节点放入栈中，进行循环判断栈是否为空
     *               1. 为空，说明只有一个节点，不需要进行反转
     *               2. 不为空，弹出栈中节点，将节点左右节点进行反转，反转后将左右节点放入栈中
     * @param root 树的根节点
     * @return 返回反转后的树
     */
    public TreeNode invertTree02(TreeNode root) {
        if (root == null) {
            return null;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            TreeNode tempNode = node.left;
            node.left = node.right;
            node.right = tempNode;
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(5);
    }
}
