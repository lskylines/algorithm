package com.leetcode.algorithm.tree;

import com.leetcode.algorithm.tree.Node.TreeNode;

/**
 * @ ClassName MorrisTraverse
 * @ author lskyline
 * @ 2021/4/16 16:14
 * @ Version: 1.0
 */
public class MorrisTraverse {
    /*
     * Morris遍历
     */
    public static void morris(TreeNode head) {
        if (head == null) {
            return ;
        }
        TreeNode curNode = head;
        TreeNode mostRightNode = null;
        while (curNode != null) {
            mostRightNode = curNode.left;
            if (mostRightNode != null) {
                while (mostRightNode.right != null && mostRightNode.right != curNode) {
                    mostRightNode = mostRightNode.right;
                }
                if (mostRightNode.right == null) {
                    mostRightNode.right = curNode;
                    curNode = curNode.left;
                    continue;
                } else {
                    mostRightNode.right = null;
                }
            }
            curNode = curNode.right;
        }
    }

    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.right = new TreeNode(3);
        head.left.left = new TreeNode(4);
        head.left.right = new TreeNode(5);
        morris(head);
    }
}
